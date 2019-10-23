package im.wangbo.java.usecases.jooq;

import im.wangbo.java.usecases.generated.ddl.Tables;
import java.util.stream.Stream;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.ParamType;
import org.jooq.impl.DSL;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-17 by Elvis Wang
 */
class GeneratedBasedSqlBuilderIT {


    static Stream<Arguments> dslContexts() {
        return Stream.of(
            Arguments.of(SQLDialect.DEFAULT),
            Arguments.of(SQLDialect.H2),
            Arguments.of(SQLDialect.HSQLDB),
            Arguments.of(SQLDialect.MYSQL),
            Arguments.of(SQLDialect.POSTGRES)
        );
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildSelect(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .select(Tables.AUTHOR.ID, Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME,
                Tables.BOOK.TITLE)
            .from(Tables.AUTHOR.as("u"))
            .join(Tables.BOOK.as("b"))
            .on(Tables.AUTHOR.ID.eq(Tables.BOOK.AUTHOR_ID))
            .where(Tables.AUTHOR.FIRST_NAME.eq("Elvis"))
            .and(Tables.AUTHOR.LAST_NAME.eq("Wang"))
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildInsert(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .insertInto(Tables.AUTHOR)
            .columns(Tables.AUTHOR.FIRST_NAME, Tables.AUTHOR.LAST_NAME)
            .values("Elvis", "Wang")
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildUpdate(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .update(Tables.AUTHOR)
            .set(Tables.AUTHOR.FIRST_NAME, "Elvis")
            .set(Tables.AUTHOR.LAST_NAME, "Wang")
            .where(Tables.AUTHOR.ID.eq(1993L))
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildDelete(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .delete(Tables.AUTHOR)
            .where(Tables.AUTHOR.ID.eq(1993L))
            .getSQL(ParamType.INLINED);
        System.out.print(dialect.getName() + " => " + sql);
    }
}
