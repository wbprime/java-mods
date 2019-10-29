package im.wangbo.java.usecases.guice.app;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public final class AppModule extends AbstractModule {

    @Provides
    static Stdout providesStdout() {
        return new Stdout() {
            @Override
            public Stdout print(String str) {
                System.err.print(str);
                return this;
            }

            @Override
            public Stdout println(String str) {
                System.err.println(str);
                return this;
            }
        };
    }

    @Provides
    static Stderr providesStderr() {
        return new Stderr() {
            @Override
            public Stderr print(String str) {
                System.err.print(str);
                return this;
            }

            @Override
            public Stderr println(String str) {
                System.err.println(str);
                return this;
            }
        };
    }

}
