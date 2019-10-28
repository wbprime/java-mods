package im.wangbo.java.usecases.guice;

import im.wangbo.java.usecases.guice.Database.Account;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-28 by Elvis Wang
 */
public interface UserCommandsRouter {

    CommandRouter router();

    static UserCommandsRouter create(final Account account) {
        return null;
    }

    interface Factory {

        UserCommandsRouter create(final Account account);
    }
}
