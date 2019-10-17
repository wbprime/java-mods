package im.wangbo.java.usecases.jooq;

import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.ParamType;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultDataType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-17 by Elvis Wang
 */
class SqlBuilderIT {


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
    void test_buildCreateTable(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .createTable("user")
            .column("id",
                DefaultDataType.getDataType(dialect, Long.class)
                    .identity(true)
                    .nullable(false))
            .column("name",
                DefaultDataType.getDataType(dialect, String.class)
                    .nullable(false)
                    .length(100))
            .column("created_at",
                DefaultDataType.getDataType(dialect, LocalDateTime.class)
                    .nullable(false))
            .constraint(DSL.primaryKey("id"))
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildSelect(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .select(DSL.field("u.id"), DSL.field("u.name"), DSL.field("b.book_name"))
            .from(DSL.table("user").as("u"))
            .join(DSL.table("book").as("b"))
            .on(DSL.field("u.id").eq(DSL.field("b.author_id")))
            .where(DSL.field("u.name").eq("Elvis Wang"))
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildInsert(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .insertInto(DSL.table("user"))
            .columns(DSL.field("name"), DSL.field("created_at"))
            .values(DSL.value("Elvis Wang"), DSL.value(LocalDateTime.now()))
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildUpdate(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .update(DSL.table("user"))
            .set(DSL.field("name"), "Elvis Wang")
            .set(DSL.field("created_at"), LocalDateTime.now())
            .where(DSL.field("id").eq(1993L))
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }

    @ParameterizedTest
    @MethodSource("dslContexts")
    void test_buildDelete(final SQLDialect dialect) {
        final DSLContext dsl = DSL.using(dialect);

        final String sql = dsl
            .delete(DSL.table("user"))
            .where(DSL.field("id").eq(1993L))
            .getSQL(ParamType.INLINED);
        System.out.println(dialect.getName() + " => " + sql);
    }
}
