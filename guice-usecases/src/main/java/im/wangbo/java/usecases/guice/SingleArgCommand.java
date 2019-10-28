package im.wangbo.java.usecases.guice;

import java.util.List;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public abstract class SingleArgCommand implements Command {

    @Override
    public final Result handleInput(final List<String> args) {
        if (args.size() != 1) {
            return Command.invalidCommand();
        }

        return handleArg(args.get(0));
    }

    protected abstract Result handleArg(final String arg);
}
