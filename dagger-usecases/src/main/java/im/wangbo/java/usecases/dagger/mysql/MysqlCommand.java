package im.wangbo.java.usecases.dagger.mysql;

import im.wangbo.java.usecases.dagger.app.Command;
import im.wangbo.java.usecases.dagger.app.Stderr;
import im.wangbo.java.usecases.dagger.app.Stdout;
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
final class MysqlCommand implements Command {

    private final Stdout stdout;
    private final Stderr stderr;

    private final DataSource dataSource;

    @Inject
    MysqlCommand(final DataSource dataSource, final Stdout stdout, final Stderr stderr) {
        this.dataSource = dataSource;

        this.stdout = stdout;
        this.stderr = stderr;
    }

    @Override
    public Status handleInput(final List<String> args) {
        final int n = args.size();
        if (n <= 1) {
            stderr.println("Usage: mysql sql-command");
            return Status.FAILED;
        }

        final DSLContext dsl = DSL.using(dataSource, SQLDialect.MYSQL);
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
