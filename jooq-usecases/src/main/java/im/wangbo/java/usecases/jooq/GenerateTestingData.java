package im.wangbo.java.usecases.jooq;

import javax.sql.DataSource;
import org.h2.jdbcx.JdbcConnectionPool;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultDataType;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-18 by Elvis Wang
 */
public class GenerateTestingData {

    public static void main(String[] args) {
        final String url = "jdbc:h2:./prepared.db";
        final SQLDialect dialect = SQLDialect.H2;

        final DataSource dataSource = JdbcConnectionPool.create(url, "jooq", "jOOQ@h2");
        try (final DSLContext dsl = DSL.using(dataSource, dialect)) {
            dsl.createTableIfNotExists("user")
                .column("id",
                    DefaultDataType.getDataType(dialect, Long.class)
                        .identity(true)
                        .nullable(false))
                .column("name",
                    DefaultDataType.getDataType(dialect, String.class)
                        .nullable(false)
                        .length(100))
                .column("created_millis",
                    DefaultDataType.getDataType(dialect, Long.class)
                        .nullable(false))
                .constraint(DSL.primaryKey("id"));
            dsl.createTableIfNotExists("book")
                .column("id",
                    DefaultDataType.getDataType(dialect, Long.class)
                        .identity(true)
                        .nullable(false))
                .column("name",
                    DefaultDataType.getDataType(dialect, String.class)
                        .nullable(false)
                        .length(100))
                .column("author_id",
                    DefaultDataType.getDataType(dialect, Long.class)
                        .nullable(false))
                .column("created_millis",
                    DefaultDataType.getDataType(dialect, Long.class)
                        .nullable(false))
                .constraint(DSL.primaryKey("id"));
        }
    }
}
