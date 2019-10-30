package im.wangbo.java.usecases.dagger;

import dagger.BindsInstance;
import dagger.Component;
import im.wangbo.java.usecases.dagger.app.AppModule;
import im.wangbo.java.usecases.dagger.app.CommandProcessor;
import im.wangbo.java.usecases.dagger.echo.EchoModule;
import im.wangbo.java.usecases.dagger.exit.ExitModule;
import im.wangbo.java.usecases.dagger.set.SetModule;
import im.wangbo.java.usecases.dagger.sql.SqlModule;
import im.wangbo.java.usecases.dagger.sql.SqlUtils;
import im.wangbo.java.usecases.dagger.sql.SqlUtils.JdbcUrl;
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
    SqlModule.class
})
@Singleton
interface MainComponent {

    static Builder builder() {
        return DaggerMainComponent.builder();
    }

    CommandProcessor commandProcessor();

    @Component.Builder
    interface Builder {

        Builder setJdbcUrl(@BindsInstance @JdbcUrl final String url);

        Builder setJdbcUsername(
            @BindsInstance @Named(SqlUtils.NAMED_KEY_JDBC_USERNAME) final String username);

        Builder setJdbcPassword(
            @BindsInstance @Named(SqlUtils.NAMED_KEY_JDBC_PASSWORD) final String pwd);

        MainComponent build();
    }
}
