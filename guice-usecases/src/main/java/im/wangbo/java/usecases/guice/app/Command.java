package im.wangbo.java.usecases.guice.app;

import java.util.List;

public interface Command {

    Status handleInput(final List<String> args);

    enum Status {
        INVALID,
        SUCCEED,
        FAILED,
        QUITING
    }
}
