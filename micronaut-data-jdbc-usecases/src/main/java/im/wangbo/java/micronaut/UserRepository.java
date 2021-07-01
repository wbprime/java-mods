package im.wangbo.java.micronaut;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Stream;

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
    }
