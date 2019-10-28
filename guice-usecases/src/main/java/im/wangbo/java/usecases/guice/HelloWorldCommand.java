package im.wangbo.java.usecases.guice;

import java.util.List;
import javax.inject.Inject;

public class HelloWorldCommand implements Command {

    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(final Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Result handleInput(List<String> args) {
        if (!args.isEmpty()) {
            return Result.invalidCommand();
        }
        outputter.output("world!");
        return Result.handled();
    }
}
