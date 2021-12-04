package im.wangbo.java.micronaut;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@JdbcRepository(dialect = Dialect.H2)
interface UserRepository extends CrudRepository<DUser, Long>
    {
//    Stream<DUser> findByBirthdayNotAfter(final OffsetDateTime date);

    List<DUser> findByBirthdayNotAfter(final OffsetDateTime date);

    default void inTransaction(final Runnable r)
        {
        final DUser u = new DUser();
        u.setName("Elvis Wang");
        u.setBirthday(OffsetDateTime.now());

        u.setCreatedAt(Instant.now().toEpochMilli());
        u.setLastUpdatedAt(u.getCreatedAt());

        this.save(u);
        r.run();
        }
    }
