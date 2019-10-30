package im.wangbo.java.usecases.guice.sql;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import im.wangbo.java.usecases.guice.app.Command;
import im.wangbo.java.usecases.guice.sql.SqlUtils.JdbcUrl;
import javax.inject.Named;
import javax.sql.DataSource;
import org.jooq.SQLDialect;
import org.jooq.tools.jdbc.JDBCUtils;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public final class SqlModule extends AbstractModule {

    @Override
    protected void configure() {
        final MapBinder<String, Command> binder = MapBinder.newMapBinder(
            binder(), String.class, Command.class
        );

        binder.addBinding("sql").to(SqlCommand.class);
    }

    @Provides
    private SQLDialect providesSqlDialect(@JdbcUrl final String url) {
        return JDBCUtils.dialect(url);
    }

    @Provides
    private DataSource providesDataSource(
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
