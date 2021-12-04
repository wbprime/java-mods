package im.wangbo.java.micronaut;

import org.jdbi.v3.core.Jdbi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@Singleton
class JdbiRepository
    {
    private final Jdbi jdbi;

    @Inject
    public JdbiRepository(Jdbi jdbi)
        {
        this.jdbi = jdbi;
        }

    public int countUsers1()
        {
        return jdbi.inTransaction(
            _h -> _h.select("SELECT count(_t.id) FROM t_user _t;")
                .mapTo(Integer.class)
                .findOne().orElse(0)
        );
        }

    public int countUsers2()
        {
        return jdbi.withHandle(
            _h -> _h.select("SELECT count(_t.id) FROM t_user _t;")
                .mapTo(Integer.class)
                .findOne().orElse(0)
        );
        }
    }
