package im.wangbo.java.usecases.guice.set;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import im.wangbo.java.usecases.guice.app.Command;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public class SetModule extends AbstractModule {

    @Override
    protected void configure() {
        final MapBinder<String, Command> binder = MapBinder.newMapBinder(
            binder(), String.class, Command.class
        );

        binder.addBinding("set").to(SetCommand.class);
    }
}
