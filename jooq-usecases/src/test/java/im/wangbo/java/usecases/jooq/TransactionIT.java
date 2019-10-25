package im.wangbo.java.usecases.jooq;

import im.wangbo.java.usecases.generated.ddl.Tables;
import im.wangbo.java.usecases.generated.ddl.tables.records.AuthorRecord;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-17 by Elvis Wang
 */
class TransactionIT {

    private DSLContext dsl;

    @BeforeEach
    void setUp(@TempDir final Path dir) throws Exception {
        final String url = "jdbc:h2:" + dir.toString() + "/test.db";
        final Connection connection = DriverManager.getConnection(url, "sa", "");

        dsl = DSL.using(connection, SQLDialect.H2);

        dsl.createTableIfNotExists(Tables.AUTHOR)
            .columns(Tables.AUTHOR.ID, Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME,
                Tables.AUTHOR.DATE_OF_BIRTH, Tables.AUTHOR.YEAR_OF_BIRTH)
            .constraint(DSL.primaryKey(Tables.AUTHOR.ID))
            .execute();
    }

    @AfterEach
    void tearDown() {
        dsl.close();
    }

    private void dump(final String table) {
        final Result<Record> fetch = dsl.fetch("select * from \"" + table + "\"");
        System.out.println(fetch);
    }

    private static Long throwsNothing(final AuthorRecord inserted) throws Exception {
        System.out.println("Throws Nothing when processing " + inserted.getId());
        return inserted.getId();
    }

    private static Long throwsCheckedException(final AuthorRecord inserted) throws Exception {
        System.out.println("Throws CheckedException when processing " + inserted.getId());
        throw new Exception("Failed in processing " + inserted.getId());
    }

    private static Long throwsUncheckedException(final AuthorRecord inserted) throws Exception {
        System.out.println("Throws UncheckedException when processing " + inserted.getId());
        throw new RuntimeException("Failed in processing " + inserted.getId());
    }

    interface ThrowingConsumer {

        void run(final AuthorRecord r) throws Exception;
    }

    interface ThrowingFunction<T> {

        T call(final AuthorRecord r) throws Exception;
    }

    static Stream<Arguments> runnables() {
        return Stream.<ThrowingConsumer>of(
            TransactionIT::throwsNothing,
            TransactionIT::throwsCheckedException,
            TransactionIT::throwsUncheckedException
        ).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("runnables")
    void test_transactionRun(final ThrowingConsumer runnable) {
        try {
            dsl.transaction(c -> {
                final DSLContext inner = DSL.using(c);

                final AuthorRecord inserted = inner.insertInto(Tables.AUTHOR)
                    .columns(Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME)
                    .values("Elvis", "Wang")
                    .returning(Tables.AUTHOR.ID)
                    .fetchOne();

                // assertj
                Assertions.assertThat(inserted).isNotNull();

                runnable.run(inserted);

                final int n = inner.update(Tables.AUTHOR)
                    .set(Tables.AUTHOR.FIRST_NAME, "James")
                    .set(Tables.AUTHOR.LAST_NAME, "Zhang")
                    .where(Tables.AUTHOR.ID.eq(inserted.getId()))
                    .execute();

                // assertj
                Assertions.assertThat(n).isEqualTo(1);
            });
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            System.out.println("Failed due to checked exception thrown in transaction");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            System.out.println("Failed due to unchecked exception thrown in transaction");
        }

        dump(Tables.AUTHOR.getName());
    }

    static Stream<Arguments> callables() {
        return Stream.<ThrowingFunction<Long>>of(
            TransactionIT::throwsNothing,
            TransactionIT::throwsCheckedException,
            TransactionIT::throwsUncheckedException
        ).map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("callables")
    void test_transactionCall(final ThrowingFunction<Long> callable) {
        try {
            final Long result = dsl.transactionResult(c -> {
                final DSLContext inner = DSL.using(c);

                final AuthorRecord inserted = inner.insertInto(Tables.AUTHOR)
                    .columns(Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME)
                    .values("Elvis", "Wang")
                    .returning(Tables.AUTHOR.ID)
                    .fetchOne();

                // assertj
                Assertions.assertThat(inserted).isNotNull();

                final Long val = callable.call(inserted);

                // assertj
                Assertions.assertThat(val).isNotNull();

                final int n = inner.update(Tables.AUTHOR)
                    .set(Tables.AUTHOR.FIRST_NAME, "James")
                    .set(Tables.AUTHOR.LAST_NAME, "Zhang")
                    .where(Tables.AUTHOR.ID.eq(inserted.getId()))
                    .execute();

                // assertj
                Assertions.assertThat(n).isEqualTo(1);

                return val;
            });

            // assertj
            Assertions.assertThat(result).isNotNull();
        } catch (DataAccessException ex) {
            ex.printStackTrace();
            System.out.println("Failed due to checked exception thrown in transaction");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            System.out.println("Failed due to unchecked exception thrown in transaction");
        }

        dump(Tables.AUTHOR.getName());
    }
}
