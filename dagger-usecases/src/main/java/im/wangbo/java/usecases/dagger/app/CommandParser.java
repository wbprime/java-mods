package im.wangbo.java.usecases.dagger.app;

import im.wangbo.java.usecases.dagger.app.Command.Status;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public class CommandParser {

    private final Map<String, Command> map;

    @Inject
    public CommandParser(final Map<String, Command> map) {
        this.map = map;
    }

    public Status process(final String line) {
        final List<String> args = splitByWhiteSpace(line);

        if (args.isEmpty()) {
            return Status.INVALID;
        }

        final String name = args.get(0);

        final Command cmd = map.get(name);
        if (cmd == null) {
            return Status.INVALID;
        }

        return cmd.handleInput(args.subList(1, args.size()));
    }

    private static List<String> splitByWhiteSpace(final String str) {
        return Arrays.asList(str.split("\\s+"));
    }
}
