package im.wangbo.java.usecases.guice;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class DepositCommand implements Command {
  private final Outputter outputter;

  private final Database database;

  @Inject
  public DepositCommand(final Outputter outputter, final Database database) {
    this.outputter = outputter;
    this.database = database;
  }

  @Override
  public Status handleInput(final List<String> args) {
    if (args.size() != 2) {
      return Status.INVALID;
    }

    Database.Account account = database.getAccount(args.get(0));
    account.deposit(new BigDecimal(args.get(1)));
    outputter.output(account.username() + " now has: " + account.balance());
    return Status.HANDLED;
  }
}
