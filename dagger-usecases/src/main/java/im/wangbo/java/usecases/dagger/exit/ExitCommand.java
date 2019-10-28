package im.wangbo.java.usecases.dagger.exit;

import im.wangbo.java.usecases.dagger.app.Command;
import java.util.List;
import javax.inject.Inject;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
final class ExitCommand implements Command {

    @Inject
    ExitCommand() {
    }

    @Override
    public Status handleInput(final List<String> args) {
        return Status.QUITING;
    }
}
