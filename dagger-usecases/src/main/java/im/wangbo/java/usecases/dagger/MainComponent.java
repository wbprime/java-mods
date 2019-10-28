package im.wangbo.java.usecases.dagger;

import dagger.Component;
import im.wangbo.java.usecases.dagger.app.AppModule;
import im.wangbo.java.usecases.dagger.app.CommandProcessor;
import im.wangbo.java.usecases.dagger.echo.EchoModule;
import im.wangbo.java.usecases.dagger.exit.ExitModule;
import im.wangbo.java.usecases.dagger.set.SetModule;
import javax.inject.Singleton;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
@Component(modules = {AppModule.class, ExitModule.class, EchoModule.class, SetModule.class})
@Singleton
public interface MainComponent {

    static MainComponent of() {
        return DaggerMainComponent.create();
    }

    CommandProcessor commandProcessor();
}
