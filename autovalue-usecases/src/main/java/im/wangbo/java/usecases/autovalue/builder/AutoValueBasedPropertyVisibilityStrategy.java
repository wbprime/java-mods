package im.wangbo.java.usecases.autovalue.builder;

import javax.json.bind.config.PropertyVisibilityStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-28, by Elvis Wang
 */
public class AutoValueBasedPropertyVisibilityStrategy implements PropertyVisibilityStrategy {
    @Override
    public boolean isVisible(final Field field) {
        return false;
    }

    @Override
    public boolean isVisible(final Method method) {
        return true;
    }
}
