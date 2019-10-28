package im.wangbo.java.usecases.dagger;

import java.util.List;

public interface Command {
  String key();

  Status handleInput(final List<String> args);

  enum Status {
    INVALID,
    HANDLED
  }
}
