package im.wangbo.java.usecases.guice;

import com.google.auto.factory.AutoFactory;
import com.google.auto.factory.Provided;
import im.wangbo.java.usecases.guice.Database.Account;
import java.util.Map;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
@AutoFactory(implementing = UserCommandsRouter.Factory.class)
public class StdUserCommandsRouter implements UserCommandsRouter {

    private final Outputter outputter;
    private final Map<String, Command> cmds;
    private final Account account;

    public StdUserCommandsRouter(
        @Provided final Outputter outputter,
        @Provided final Map<String, Command> cmds,
        final Account account
    ) {
        this.outputter = outputter;
        this.cmds = cmds;
        this.account = account;
    }

    @Override
    public CommandRouter router() {
        return new CommandRouter(outputter, cmds);
    }
}
