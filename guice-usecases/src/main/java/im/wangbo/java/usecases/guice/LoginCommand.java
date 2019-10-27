package im.wangbo.java.usecases.guice;

import javax.inject.Inject;
import java.util.List;

public class LoginCommand implements Command {
  private final Outputter outputter;

  @Inject
  public LoginCommand(Outputter outputter) {
    this.outputter = outputter;
  }

  @Override
  public Status handleInput(final List<String> args) {
    if (args.size() != 1) {
      return Command.invalidCommand();
    }

    final String username = args.get(0);

    outputter.output(username + " is logged in.");
    return Status.HANDLED;
  }
}
