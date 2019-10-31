package im.wangbo.java.usecases.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-30 by Elvis Wang
 */
public class JdbcPlainSqlApp {

    private static void print(final String str) {
        System.out.println();
        System.out.println(">>> " + str);
    }

    private static void processOnConnection(final Connection c) throws Exception {
        print("Connected to server.");

        // Create database objects.
        try (Statement stmt = c.createStatement()) {
            // Create reference City table based on REPLICATED template.
            stmt.executeUpdate("CREATE TABLE city (id LONG PRIMARY KEY, name VARCHAR) " +
                "WITH \"template=replicated\"");

            // Create table based on PARTITIONED template with one backup.
            stmt.executeUpdate("CREATE TABLE person (id LONG, name VARCHAR, city_id LONG, " +
                "PRIMARY KEY (id, city_id)) WITH \"backups=1, affinity_key=city_id\"");

            // Create an index.
            stmt.executeUpdate("CREATE INDEX on Person (city_id)");
        }

        print("Created database objects.");

        // Populate City table with PreparedStatement.
        try (PreparedStatement stmt = c
            .prepareStatement("INSERT INTO city (id, name) VALUES (?, ?)")) {
            stmt.setLong(1, 1L);
            stmt.setString(2, "Forest Hill");
            stmt.executeUpdate();

            stmt.setLong(1, 2L);
            stmt.setString(2, "Denver");
            stmt.executeUpdate();

            stmt.setLong(1, 3L);
            stmt.setString(2, "St. Petersburg");
            stmt.executeUpdate();
        }

        // Populate Person table with PreparedStatement.
        try (PreparedStatement stmt =
            c.prepareStatement("INSERT INTO person (id, name, city_id) values (?, ?, ?)")) {
            stmt.setLong(1, 1L);
            stmt.setString(2, "John Doe");
            stmt.setLong(3, 3L);
            stmt.executeUpdate();

            stmt.setLong(1, 2L);
            stmt.setString(2, "Jane Roe");
            stmt.setLong(3, 2L);
            stmt.executeUpdate();

            stmt.setLong(1, 3L);
            stmt.setString(2, "Mary Major");
            stmt.setLong(3, 1L);
            stmt.executeUpdate();

            stmt.setLong(1, 4L);
            stmt.setString(2, "Richard Miles");
            stmt.setLong(3, 2L);
            stmt.executeUpdate();
        }

        print("Populated data.");

        // Get data.
        try (Statement stmt = c.createStatement()) {
            try (ResultSet rs =
                stmt.executeQuery(
                    "SELECT p.name, c.name FROM Person p INNER JOIN City c on c.id = p.city_id")) {
                print("Query results:");

                while (rs.next()) {
                    System.out.println(">>>    " + rs.getString(1) + ", " + rs.getString(2));
                }
            }
        }

        // Drop database objects.
        try (Statement stmt = c.createStatement()) {
            stmt.executeUpdate("DROP TABLE Person");
            stmt.executeUpdate("DROP TABLE City");
        }

        print("Dropped database objects.");

        print("JDBC example finished.");
    }

    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1/")) {
            processOnConnection(conn);
        }
    }
}
