package im.wangbo.java.usecases.guice;

import javax.inject.Inject;
import java.util.List;

public class LoginCommand implements Command {
  private final Outputter outputter;

  private final Database database;

  @Inject
  public LoginCommand(final Outputter outputter, final Database database) {
    this.outputter = outputter;
    this.database = database;
  }

  @Override
  public Result handleInput(final List<String> args) {
    if (args.size() != 1) {
      return Command.invalidCommand();
    }

    final String username = args.get(0);

    final Database.Account account = database.getAccount(username);

    outputter.output(username + " is logged in with balance: " + account.balance());
    return Result.enterNestedCommandSet();
  }
}
