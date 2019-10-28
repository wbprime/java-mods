package im.wangbo.java.usecases.guice;

import javax.inject.Inject;

public class HelloWorldCommand extends NoArgCommand implements Command {

    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(final Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    public Result handle() {
        outputter.output("world!");
        return Result.handled();
    }
}
