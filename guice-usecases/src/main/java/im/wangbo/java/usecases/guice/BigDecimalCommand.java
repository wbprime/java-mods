package im.wangbo.java.usecases.guice;

import java.math.BigDecimal;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public abstract class BigDecimalCommand extends SingleArgCommand implements Command {

    private final Outputter outputter;

    protected BigDecimalCommand(final Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    protected final Result handleArg(final String arg) {
        BigDecimal amount = tryParse(arg);
        if (amount == null) {
            outputter.output(arg + " is not a valid number");
        } else if (amount.signum() <= 0) {
            outputter.output("amount must be positive");
        } else {
            handleAmount(amount);
        }
        return Result.handled();
    }

    private static BigDecimal tryParse(String arg) {
        try {
            return new BigDecimal(arg);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    protected abstract void handleAmount(final BigDecimal amount);
}
