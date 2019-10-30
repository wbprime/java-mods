package im.wangbo.java.usecases.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import im.wangbo.java.usecases.guice.app.AppModule;
import im.wangbo.java.usecases.guice.echo.EchoModule;
import im.wangbo.java.usecases.guice.exit.ExitModule;
import im.wangbo.java.usecases.guice.set.SetModule;
import im.wangbo.java.usecases.guice.sql.SqlModule;
import im.wangbo.java.usecases.guice.sql.SqlUtils;
import im.wangbo.java.usecases.guice.sql.SqlUtils.JdbcUrl;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
final class MainModule extends AbstractModule {

    private final String jdbcUrl;
    private final String jdbcUsername;
    private final String jdbcPwd;

    MainModule(final String url, final String username, final String pwd) {
        this.jdbcUrl = url;
        this.jdbcUsername = username;
        this.jdbcPwd = pwd;
    }

    @Override
    protected void configure() {
        bindConstant().annotatedWith(JdbcUrl.class).to(jdbcUrl);
        bindConstant().annotatedWith(Names.named(SqlUtils.NAMED_KEY_JDBC_USERNAME))
            .to(jdbcUsername);
        bindConstant().annotatedWith(Names.named(SqlUtils.NAMED_KEY_JDBC_PASSWORD))
            .to(jdbcPwd);

        install(new AppModule());
        install(new EchoModule());
        install(new SetModule());
        install(new ExitModule());
        install(new SqlModule());
    }
}
