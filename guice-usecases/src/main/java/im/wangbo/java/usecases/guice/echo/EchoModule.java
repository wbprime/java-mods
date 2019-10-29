package im.wangbo.java.usecases.guice.echo;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import im.wangbo.java.usecases.guice.app.Command;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public final class EchoModule extends AbstractModule {

    @Override
    protected void configure() {
        final MapBinder<String, Command> binder = MapBinder.newMapBinder(
            binder(), String.class, Command.class
        );

        binder.addBinding("echo").to(EchoCommand.class);
    }
}
