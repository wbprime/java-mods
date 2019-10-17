package im.wangbo.java.usecases.jooq;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.OffsetDateTime;
import java.util.stream.Stream;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-17 by Elvis Wang
 */
class SqlExecutorIT {

    private DSLContext dsl;

    @BeforeEach
    void setUp(@TempDir final Path dir) throws Exception {
        final String url = "jdbc:h2:" + dir.toString() + "/test.db";
        final Connection connection = DriverManager.getConnection(url, "sa", "");

        dsl = DSL.using(connection, SQLDialect.H2);
    }

    private void dump(final String table) {
        final Result<Record> fetch = dsl.fetch("select * from \"" + table + "\"");
        System.out.println(fetch);
    }

    @Test
    void test_executeCreateTable() {
        dsl.execute("create table \"user\"(\n"
            + "    \"id\" bigint not null auto_increment, "
            + "    \"name\" varchar(100) not null, "
            + "    \"created_at\" timestamp not null, "
            + "    primary key (\"id\")"
            + ");");

        dump("user");
    }

    @Test
    void test_executeInsert() {
        dsl.execute("create table \"user\"(\n"
            + "    \"id\" bigint not null auto_increment, "
            + "    \"name\" varchar(100) not null, "
            + "    \"created_at\" timestamp not null, "
            + "    primary key (\"id\")"
            + ");");

        final Stream<String> names = Stream.of("Elvis Wang", "Elvis Zhang", "Elvis Liang");
        names.forEach(
            n -> dsl.execute("insert into \"user\" (\"name\", \"created_at\") "
                    + "values (cast(? as varchar), cast(? as timestamp))",
                n, OffsetDateTime.now())
        );

        dump("user");
    }

    @Test
    void test_executeSelect() {
        dsl.execute("create table \"user\"(\n"
            + "    \"id\" bigint not null auto_increment, "
            + "    \"name\" varchar(100) not null, "
            + "    \"created_at\" timestamp not null, "
            + "    primary key (\"id\")"
            + ");");

        final Stream<String> names = Stream.of("Elvis Wang", "Elvis Zhang", "Elvis Liang");
        names.forEach(
            n -> dsl.execute(
                "insert into \"user\" (\"name\", \"created_at\") "
                    + "values (cast(? as varchar), cast(? as timestamp))",
                n, OffsetDateTime.now())
        );

        final Result<Record> fetch = dsl.fetch("select * from \"user\"");
        System.out.println(fetch);
    }

    @Test
    void test_executeUpdate() {
        dsl.execute("create table \"user\"(\n"
            + "    \"id\" bigint not null auto_increment, "
            + "    \"name\" varchar(100) not null, "
            + "    \"created_at\" timestamp not null, "
            + "    primary key (\"id\")"
            + ");");

        final Stream<String> names = Stream.of("Elvis Wang", "Elvis Zhang", "Elvis Liang");
        names.forEach(
            n -> dsl.execute(
                "insert into \"user\" (\"name\", \"created_at\") "
                    + "values (cast(? as varchar), cast(? as timestamp))",
                n, OffsetDateTime.now())
        );

        dsl.execute("update \"user\" "
            + "    set \"name\" = 'Elvis Wang', "
            + "        \"created_at\" = timestamp '2019-10-17 19:46:58.456' "
            + "    where \"id\" = ?", 2);

        dump("user");
    }

    @Test
    void test_executeDelete() {
        dsl.execute("create table \"user\"(\n"
            + "    \"id\" bigint not null auto_increment, "
            + "    \"name\" varchar(100) not null, "
            + "    \"created_at\" timestamp not null, "
            + "    primary key (\"id\")"
            + ");");

        final Stream<String> names = Stream.of("Elvis Wang", "Elvis Zhang", "Elvis Liang");
        names.forEach(
            n -> dsl.execute(
                "insert into \"user\" (\"name\", \"created_at\") "
                    + "values (cast(? as varchar), cast(? as timestamp))",
                n, OffsetDateTime.now())
        );

        dsl.execute("delete from \"user\" where \"id\" = ?", 2);

        dump("user");
    }
}
