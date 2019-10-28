package im.wangbo.java.usecases.guice;

import javax.inject.Inject;
import java.util.ArrayDeque;
import java.util.Deque;
import im.wangbo.java.usecases.guice.Command.Result;
import im.wangbo.java.usecases.guice.Command.Status;

public class CommandProcessor {
  private final Deque<CommandRouter> stack = new ArrayDeque<>();

  @Inject
  public CommandProcessor(final CommandRouter router) {
    this.stack.push(router);
  }

  Status process(final String input) {
    final Result result = stack.peek().route(input);
    if (result.status().equals(Status.INPUT_COMPLETED)) {
      stack.pop();
      return stack.isEmpty() ? Status.INPUT_COMPLETED : Status.HANDLED;
    }

    result.nestedCommandRouter().ifPresent(stack::push);
    return result.status();
  }
}
