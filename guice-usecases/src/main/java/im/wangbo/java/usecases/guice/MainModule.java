package im.wangbo.java.usecases.guice;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import im.wangbo.java.usecases.guice.app.AppModule;
import im.wangbo.java.usecases.guice.echo.EchoModule;
import im.wangbo.java.usecases.guice.exit.ExitModule;
import im.wangbo.java.usecases.guice.mysql.MysqlModule;
import im.wangbo.java.usecases.guice.set.SetModule;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
final class MainModule extends AbstractModule {

    private final String mysqlHost;
    private final int mysqlPort;
    private final String mysqlUsername;
    private final String mysqlPwd;

    MainModule(final String mysqlHost, final int mysqlPort,
        final String mysqlUsername, final String mysqlPwd) {

        this.mysqlHost = mysqlHost;
        this.mysqlPort = mysqlPort;
        this.mysqlUsername = mysqlUsername;
        this.mysqlPwd = mysqlPwd;
    }

    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("mysql_host")).to(mysqlHost);
        bindConstant().annotatedWith(Names.named("mysql_port")).to(mysqlPort);
        bindConstant().annotatedWith(Names.named("mysql_username")).to(mysqlUsername);
        bindConstant().annotatedWith(Names.named("mysql_password")).to(mysqlPwd);

        install(new AppModule());
        install(new EchoModule());
        install(new SetModule());
        install(new ExitModule());
        install(new MysqlModule());
    }
}
