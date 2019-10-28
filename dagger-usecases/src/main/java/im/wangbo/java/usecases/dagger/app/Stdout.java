package im.wangbo.java.usecases.dagger.app;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public interface Stdout {

    Stdout print(final String str);

    Stdout println(final String str);
}
