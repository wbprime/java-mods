package im.wangbo.java.usecases.guice;

import javax.inject.Inject;
import java.util.List;

public class HelloWorldCommand implements Command {
  private final Outputter outputter;

  @Inject
  public HelloWorldCommand(final Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public Status handleInput(List<String> args) {
    if (!args.isEmpty()) {
      return Status.INVALID;
    }
    outputter.output("world!");
    return Status.HANDLED;
  }
}
