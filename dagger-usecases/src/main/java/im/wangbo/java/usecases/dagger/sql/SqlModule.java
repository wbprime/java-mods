package im.wangbo.java.usecases.dagger.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import im.wangbo.java.usecases.dagger.app.Command;
import im.wangbo.java.usecases.dagger.sql.SqlUtils.JdbcUrl;
import javax.inject.Named;
import javax.sql.DataSource;
import org.jooq.SQLDialect;
import org.jooq.tools.jdbc.JDBCUtils;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
@Module
public abstract class SqlModule {

    @Binds
    @IntoMap
    @StringKey("sql")
    abstract Command bindsCommand(final SqlCommand c);

    @Provides
    static SQLDialect providesSqlDialect(@JdbcUrl final String url) {
        return JDBCUtils.dialect(url);
    }

    @Provides
    static DataSource providesDataSource(
        @JdbcUrl final String url,
        @Named(SqlUtils.NAMED_KEY_JDBC_USERNAME) final String username,
        @Named(SqlUtils.NAMED_KEY_JDBC_PASSWORD) final String pwd) {
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(pwd);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }
}
