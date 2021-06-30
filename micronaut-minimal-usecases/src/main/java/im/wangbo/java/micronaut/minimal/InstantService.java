package im.wangbo.java.micronaut.minimal;

import javax.inject.Inject;
import java.time.Clock;
import java.time.Instant;
import java.util.Optional;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
class InstantService
    {
    private final Clock clock;
    private final Optional<InstantConsumer> consumer;

    @Inject
    public InstantService(Clock clock, Optional<InstantConsumer> consumer)
        {
        this.clock = clock;
        this.consumer = consumer;
        }

    public void action()
        {
        consumer.ifPresent(_v -> _v.accept(Instant.now(clock)));
        }
    }
