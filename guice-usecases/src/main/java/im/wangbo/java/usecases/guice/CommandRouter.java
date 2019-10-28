package im.wangbo.java.usecases.guice;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import im.wangbo.java.usecases.guice.Command.Status;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class CommandRouter {
  private final Outputter outputter;
  private final Map<String, Command> commands = Maps.newHashMap();

  @Inject
  public CommandRouter(final Outputter outputter, final Map<String, Command> cmds) {
    this.outputter = outputter;
    this.commands.putAll(cmds);
  }

  Command.Result route(final String input) {
    final List<String> splitInput = split(input);
    if (splitInput.isEmpty()) {
      return invalidCommand(input);
    }

    final String commandKey = splitInput.get(0);
    final Command command = commands.get(commandKey);
    if (command == null) {
      return invalidCommand(input);
    }

    final Status status = command.handleInput(splitInput.subList(1, splitInput.size()));
    if (status.equals(Status.INVALID)) {
      outputter.output(commandKey + ": invalid arguments");
    }

    return Command.Result.of(Status.HANDLED);
  }

  private Command.Result invalidCommand(String input) {
    outputter.output(String.format("couldn't understand \"%s\". please try again.", input));
    return Command.Result.invalidCommand();
  }

  // Split on whitespace
  private static List<String> split(final String string) {
    return Splitter.on(CharMatcher.whitespace())
        .trimResults()
        .omitEmptyStrings()
        .splitToList(string);
  }
}
