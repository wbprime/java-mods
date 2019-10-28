package im.wangbo.java.usecases.guice;

import javax.inject.Inject;

public class LoginCommand extends SingleArgCommand implements Command {

    private final Outputter outputter;

    private final Database database;

    private final UserCommandsRouter.Factory factory;

    @Inject
    public LoginCommand(
        final Outputter outputter, final Database database,
        final UserCommandsRouter.Factory factory) {
        this.outputter = outputter;
        this.database = database;
        this.factory = factory;
    }

    @Override
    public Result handleArg(final String arg) {
        final String username = arg;

        final Database.Account account = database.getAccount(username);

        outputter.output(username + " is logged in with balance: " + account.balance());
        return Result.enterNestedCommandSet(factory.create(account).router());
    }
}
