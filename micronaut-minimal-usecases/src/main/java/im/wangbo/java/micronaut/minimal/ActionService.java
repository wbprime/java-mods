package im.wangbo.java.micronaut.minimal;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@Singleton
class ActionService
    {
    private final Clock clock;
    private final Iterable<DateTimeConsumer> consumers;

    @Inject
    public ActionService(Clock clock, List<DateTimeConsumer> consumers)
        {
        this.clock = clock;
        this.consumers = consumers;
        }

    public void action()
        {
        final LocalDateTime now = LocalDateTime.now(clock);

        consumers.forEach(_c -> _c.accept(now));
        }
    }
