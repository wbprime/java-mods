package im.wangbo.java.usecases.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-30 by Elvis Wang
 */
public class JooqPlainSqlApp {

    private static void print(final String str) {
        System.out.println();
        System.out.println(">>> " + str);
    }

    private static void processOnConnection(final Connection c) throws Exception {
        print("Connected to server.");

        final DSLContext dsl = DSL.using(c);

        // Create database objects.
        // Create reference City table based on REPLICATED template.
        dsl.execute("CREATE TABLE city (id LONG PRIMARY KEY, name VARCHAR) " +
            "WITH \"template=replicated\"");

        // Create table based on PARTITIONED template with one backup.
        dsl.execute("CREATE TABLE person (id LONG, name VARCHAR, city_id LONG, " +
            "PRIMARY KEY (id, city_id)) WITH \"backups=1, affinity_key=city_id\"");

        // Create an index.
        dsl.execute("CREATE INDEX on Person (city_id)");

        print("Created database objects.");

        // Populate City table with PreparedStatement.
        dsl.execute("INSERT INTO city (id, name) VALUES (?, ?)", 1L, "Forest Hill");
        dsl.execute("INSERT INTO city (id, name) VALUES (?, ?)", 2L, "Denver");
        dsl.execute("INSERT INTO city (id, name) VALUES (?, ?)", 3L, "St. Peterburg");

        // Populate Person table with PreparedStatement.
        dsl.execute("INSERT INTO person (id, name, city_id) values (?, ?, ?)",
            1L, "John Doe", 3L);
        dsl.execute("INSERT INTO person (id, name, city_id) values (?, ?, ?)",
            2L, "Jane Roe", 2L);
        dsl.execute("INSERT INTO person (id, name, city_id) values (?, ?, ?)",
            3L, "Mary Major", 1L);
        dsl.execute("INSERT INTO person (id, name, city_id) values (?, ?, ?)",
            4L, "Richard Miles", 2L);

        print("Populated data.");

        // Get data.
        final Result<Record> list =
            dsl.fetch("SELECT p.name, c.name FROM Person p INNER JOIN City c on c.id = p.city_id");

        print("Query results:");
        list.forEach(
            r -> System.out.println(
                ">>>    " + r.get(0, String.class) + ", " + r.get(1, String.class))
        );

        // Drop database objects.
        dsl.execute("DROP TABLE Person");
        dsl.execute("DROP TABLE City");

        print("Dropped database objects.");

        print("JDBC example finished.");
    }

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/")) {
            processOnConnection(conn);
        }
    }
}
