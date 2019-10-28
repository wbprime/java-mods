package im.wangbo.java.usecases.guice;

import java.util.List;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public abstract class NoArgCommand implements Command {

    @Override
    public final Result handleInput(final List<String> args) {
        if (!args.isEmpty()) {
            return Command.invalidCommand();
        }

        return handle();
    }

    protected abstract Result handle();
}
