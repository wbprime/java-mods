package im.wangbo.java.usecases.guice;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import im.wangbo.java.usecases.guice.Command.Result;
import im.wangbo.java.usecases.guice.Command.Status;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

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

        final Result result = command.handleInput(splitInput.subList(1, splitInput.size()));
        return result.status().equals(Status.INVALID) ?
            invalidCommand(input) : result;
    }

    private Result invalidCommand(String input) {
        outputter.output(String.format("couldn't understand \"%s\". please try again.", input));
        return Result.invalidCommand();
    }

    // Split on whitespace
    private static List<String> split(final String string) {
        return Splitter.on(CharMatcher.whitespace())
            .trimResults()
            .omitEmptyStrings()
            .splitToList(string);
    }
}
