package im.wangbo.java.usecases.guice;

import java.util.List;

public interface Command {
  Status handleInput(final List<String> args);

  static Status invalidCommand() {
    return Status.INVALID;
  }

  enum Status {
    INVALID,
    HANDLED
  }
}
