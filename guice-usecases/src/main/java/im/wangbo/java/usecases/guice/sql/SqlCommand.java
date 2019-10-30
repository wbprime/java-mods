package im.wangbo.java.usecases.guice.sql;

import im.wangbo.java.usecases.guice.app.Command;
import im.wangbo.java.usecases.guice.app.Stderr;
import im.wangbo.java.usecases.guice.app.Stdout;
import java.util.List;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
final class SqlCommand implements Command {

    private final Stdout stdout;
    private final Stderr stderr;

    private final SQLDialect dialect;
    private final DataSource dataSource;

    @Inject
    SqlCommand(final DataSource dataSource,
        final SQLDialect dialect,
        final Stdout stdout, final Stderr stderr) {

        this.dataSource = dataSource;
        this.dialect = dialect;

        this.stdout = stdout;
        this.stderr = stderr;
    }

    @Override
    public Status handleInput(final List<String> args) {
        final int n = args.size();
        if (n <= 1) {
            stderr.println("Usage: sql SQL-commands");
            return Status.FAILED;
        }

        final DSLContext dsl = DSL.using(dataSource, dialect);
        try {
            final int re = dsl.execute(String.join(" ", args));
            stdout.println("Return code: " + re);
            return Status.SUCCEED;
        } catch (DataAccessException ex) {
            stderr.println(ex.getMessage());
            return Status.FAILED;
        }
    }
}
