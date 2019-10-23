package im.wangbo.java.usecases.jooq;

import im.wangbo.java.usecases.generated.ddl.Tables;
import im.wangbo.java.usecases.generated.ddl.tables.records.AuthorRecord;
import java.nio.file.Path;
import java.util.Optional;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-17 by Elvis Wang
 */
@Disabled
class GeneratedBasedSqlExecutorIT {

    private DSLContext dsl;

    @BeforeEach
    void setUp(@TempDir final Path dir) throws Exception {
        dsl = DSL.using(SQLDialect.POSTGRES);
    }

    @Test
    void test_executeInsert() {
        final Optional<AuthorRecord> inserted = dsl.insertInto(Tables.AUTHOR)
            .columns(Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME)
            .values("Elvis", "Wang")
            .returning(Tables.AUTHOR.ID)
            .fetchOptional();

        inserted.ifPresent(r -> System.out.println(r.getId()));
    }

    @Test
    void test_executeSelect() {
        final Result<Record4<Long, String, String, String>> fetched =
            dsl.select(Tables.AUTHOR.ID, Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME,
                Tables.BOOK.TITLE)
                .from(Tables.AUTHOR.as("u"))
                .join(Tables.BOOK.as("b"))
                .on(Tables.AUTHOR.ID.eq(Tables.BOOK.AUTHOR_ID))
                .where(Tables.AUTHOR.FIRST_NAME.eq("Elvis"))
                .and(Tables.AUTHOR.LAST_NAME.eq("Wang"))
                .fetch();

        fetched.forEach(
            r -> System.out.println(
                String.format("Author ID: %d, name %s %s, book title %s",
                    r.value1(), r.value2(), r.value3(), r.value4())
            )
        );
    }

    @Test
    void test_executeUpdate() {
        final int n = dsl.update(Tables.AUTHOR)
            .set(Tables.AUTHOR.FIRST_NAME, "Elvis")
            .set(Tables.AUTHOR.LAST_NAME, "Wang")
            .where(Tables.AUTHOR.ID.eq(1993L))
            .execute();

        System.out.println("Update " + n + " records");
    }

    @Test
    void test_executeDelete() {
        final int n = dsl
            .delete(Tables.AUTHOR)
            .where(Tables.AUTHOR.ID.eq(1993L))
            .execute();

        System.out.println("Delete " + n + " records");
    }
}
