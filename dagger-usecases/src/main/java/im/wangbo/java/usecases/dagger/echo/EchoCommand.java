package im.wangbo.java.usecases.dagger.echo;

import im.wangbo.java.usecases.dagger.app.Command;
import im.wangbo.java.usecases.dagger.app.GlobalContext;
import im.wangbo.java.usecases.dagger.app.Stdout;
import java.util.List;
import javax.inject.Inject;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
final class EchoCommand implements Command {

    private final Stdout stdout;
    private final GlobalContext ctx;

    @Inject
    EchoCommand(final GlobalContext ctx, final Stdout stdout) {
        this.ctx = ctx;
        this.stdout = stdout;
    }

    @Override
    public Status handleInput(final List<String> args) {
        final int n = args.size();
        for (int i = 0; i < n - 1; i++) {
            stdout.print(ctx.resolve(args.get(i))).print(" ");
        }

        if (n > 0) {
            stdout.println(ctx.resolve(args.get(n - 1)));
        }
        return Status.SUCCEED;
    }
}
