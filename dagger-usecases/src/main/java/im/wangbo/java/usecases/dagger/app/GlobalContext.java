package im.wangbo.java.usecases.dagger.app;

import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
@Singleton
public class GlobalContext {

    private final Map<String, String> env;

    @Inject
    public GlobalContext() {
        final Map<String, String> env = System.getenv();
        this.env = new HashMap<>(env);
    }

    public final String resolve(final String k) {
        if (k.startsWith("$") && k.length() > 1) {
            return get(k.substring(1));
        } else {
            return k;
        }
    }

    public final String get(final String k) {
        return env.getOrDefault(k, "");
    }

    public final void set(final String k, final String v) {
        env.put(k, v);
    }

}
