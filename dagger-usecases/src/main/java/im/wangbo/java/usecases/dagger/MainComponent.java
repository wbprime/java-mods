package im.wangbo.java.usecases.dagger;

import dagger.BindsInstance;
import dagger.Component;
import im.wangbo.java.usecases.dagger.app.AppModule;
import im.wangbo.java.usecases.dagger.app.CommandProcessor;
import im.wangbo.java.usecases.dagger.echo.EchoModule;
import im.wangbo.java.usecases.dagger.exit.ExitModule;
import im.wangbo.java.usecases.dagger.mysql.MysqlModule;
import im.wangbo.java.usecases.dagger.set.SetModule;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
@Component(modules = {
    AppModule.class,
    ExitModule.class,
    EchoModule.class,
    SetModule.class,
    MysqlModule.class
})
@Singleton
interface MainComponent {

    static Builder builder() {
        return DaggerMainComponent.builder();
    }

    CommandProcessor commandProcessor();

    @Component.Builder
    interface Builder {

        Builder setMysqlHost(@BindsInstance @Named("mysql_host") final String host);

        Builder setMysqlPort(@BindsInstance @Named("mysql_port") final int port);

        Builder setMysqlUsername(@BindsInstance @Named("mysql_username") final String username);

        Builder setMysqlPassword(@BindsInstance @Named("mysql_password") final String pwd);

        MainComponent build();
    }
}
