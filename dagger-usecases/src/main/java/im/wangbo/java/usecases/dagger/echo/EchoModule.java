package im.wangbo.java.usecases.dagger.echo;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import im.wangbo.java.usecases.dagger.app.Command;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
@Module
public abstract class EchoModule {

    @Binds
    @IntoMap
    @StringKey("echo")
    abstract Command bindsEchoModule(final EchoCommand c);
}