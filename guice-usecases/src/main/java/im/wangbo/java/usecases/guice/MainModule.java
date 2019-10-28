package im.wangbo.java.usecases.guice;

import com.google.inject.AbstractModule;
import im.wangbo.java.usecases.guice.app.AppModule;
import im.wangbo.java.usecases.guice.echo.EchoModule;
import im.wangbo.java.usecases.guice.exit.ExitModule;
import im.wangbo.java.usecases.guice.set.SetModule;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
final class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new AppModule());
        install(new EchoModule());
        install(new SetModule());
        install(new ExitModule());
    }
}
