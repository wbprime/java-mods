package im.wangbo.java.usecases.guice.sql;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-30 by Elvis Wang
 */
public final class SqlUtils {

    private SqlUtils() {
        throw new UnsupportedOperationException("Construction forbidden");
    }

    @Qualifier
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PARAMETER})
    public @interface JdbcUrl {

    }

    public static final String NAMED_KEY_JDBC_USERNAME = "jdbc_username";
    public static final String NAMED_KEY_JDBC_PASSWORD = "jdbc_password";
}
