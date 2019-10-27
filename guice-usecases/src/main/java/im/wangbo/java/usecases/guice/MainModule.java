package im.wangbo.java.usecases.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;

public class MainModule extends AbstractModule {
  @Override
  protected void configure() {
    {
      final MapBinder<String, Command> mapBinder =
          MapBinder.newMapBinder(binder(), String.class, Command.class);

      mapBinder.addBinding(Commands.HELLO).to(HelloWorldCommand.class);
      mapBinder.addBinding(Commands.LOGIN).to(LoginCommand.class);
      mapBinder.addBinding(Commands.DEPOSIT).to(DepositCommand.class);
    }

    bind(CommandRouter.class);
  }

  @Provides
  private Outputter providesOutputter() {
    return System.out::println;
  }
}
