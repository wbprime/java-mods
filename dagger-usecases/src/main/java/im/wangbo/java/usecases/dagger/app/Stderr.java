package im.wangbo.java.usecases.dagger.app;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public interface Stderr {

    Stderr print(final String str);

    Stderr println(final String str);
}
