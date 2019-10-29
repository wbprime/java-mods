package im.wangbo.java.usecases.dagger.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dagger.Binds;
import dagger.BindsOptionalOf;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import im.wangbo.java.usecases.dagger.app.Command;
import java.util.Optional;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
@Module
public abstract class MysqlModule {

    @Binds
    @IntoMap
    @StringKey("mysql")
    abstract Command bindsCommand(final MysqlCommand c);

    @Provides
    static DataSource providesDataSource(
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

    @BindsOptionalOf
    @Named("mysql_port")
    abstract Integer providesDefaultMysqlPort();
}
