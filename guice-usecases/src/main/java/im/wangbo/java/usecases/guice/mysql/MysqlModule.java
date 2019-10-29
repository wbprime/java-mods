package im.wangbo.java.usecases.guice.mysql;

import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.OptionalBinder;
import com.google.inject.name.Names;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import im.wangbo.java.usecases.guice.app.Command;
import java.util.Optional;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public final class MysqlModule extends AbstractModule {

    @Override
    protected void configure() {
        {
            final MapBinder<String, Command> binder = MapBinder.newMapBinder(
                binder(), String.class, Command.class
            );

            binder.addBinding("mysql").to(MysqlCommand.class);
        }

        {
            @SuppressWarnings("unused") final OptionalBinder<Integer> binder =
                OptionalBinder.newOptionalBinder(binder(),
                    Key.get(Integer.class, Names.named("mysql_port"))
                );
        }
    }

    @Provides
    private DataSource providesDataSource(
        @Named("mysql_host") final String host,
        @Named("mysql_port") final Optional<Integer> port,
        @Named("mysql_username") final String username,
        @Named("mysql_password") final String pwd) {
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + host + port.map(n -> ":" + n).orElse("") + "/usecases");
        config.setUsername(username);
        config.setPassword(pwd);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }
}
