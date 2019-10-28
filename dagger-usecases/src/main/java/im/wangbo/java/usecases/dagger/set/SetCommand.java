package im.wangbo.java.usecases.dagger.set;

import im.wangbo.java.usecases.dagger.app.Command;
import im.wangbo.java.usecases.dagger.app.GlobalContext;
import im.wangbo.java.usecases.dagger.app.Stderr;
import java.util.List;
import javax.inject.Inject;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
final class SetCommand implements Command {

    private final Stderr stderr;
    private final GlobalContext ctx;

    @Inject
    SetCommand(final GlobalContext ctx, final Stderr stderr) {
        this.ctx = ctx;

        this.stderr = stderr;
    }

    @Override
    public Status handleInput(final List<String> args) {
        final int n = args.size();
        if (n != 2) {
            stderr.println("Usage: set name value");
            return Status.FAILED;
        }

        ctx.set(args.get(0), args.get(1));
        return Status.SUCCEED;
    }
}
