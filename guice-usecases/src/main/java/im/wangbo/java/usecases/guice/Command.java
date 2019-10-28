package im.wangbo.java.usecases.guice;

import java.util.List;
import java.util.Optional;

public interface Command {
  Result handleInput(final List<String> args);

  static Result invalidCommand() {
    return Result.invalidCommand();
  }

  class Result {
    private final Status status;
    private final Optional<CommandRouter> nestedCommandRouter;

    private Result(final Status status, final Optional<CommandRouter> nestedCommandRouter) {
      this.status = status;
      this.nestedCommandRouter = nestedCommandRouter;
    }

    public Status status() {
      return status;
    }

    public Optional<CommandRouter> nestedCommandRouter() {
      return nestedCommandRouter;
    }

    static Result enterNestedCommandSet(final CommandRouter router) {
      return new Result(Status.HANDLED, Optional.of(router));
    }

    static Result of(final Status status) {
      return new Result(status, Optional.empty());
    }

    static Result invalidCommand() {
      return new Result(Status.HANDLED, Optional.empty());
    }
  }

  enum Status {
    INVALID,
    HANDLED,
    INPUT_COMPLETED
  }
}
