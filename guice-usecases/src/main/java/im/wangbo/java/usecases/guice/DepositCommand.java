package im.wangbo.java.usecases.guice;

import im.wangbo.java.usecases.guice.Database.Account;
import java.math.BigDecimal;
import javax.inject.Inject;

public class DepositCommand extends BigDecimalCommand implements Command {

    private final Outputter outputter;

    private final Account account;

    @Inject
    public DepositCommand(final Outputter outputter, final Account account) {
        super(outputter);

        this.outputter = outputter;
        this.account = account;
    }

    @Override
    public void handleAmount(final BigDecimal amount) {
        account.deposit(amount);
        outputter.output(account.username() + " now has: " + account.balance());
    }
}
