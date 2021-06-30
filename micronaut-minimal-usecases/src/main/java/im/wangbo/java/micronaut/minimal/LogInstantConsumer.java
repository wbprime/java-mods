package im.wangbo.java.micronaut.minimal;

import io.micronaut.context.annotation.Requires;

import javax.inject.Singleton;
import java.time.Instant;
import java.util.logging.Logger;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@Singleton
@Requires(property = Application.FLAG, value = "true")
class LogInstantConsumer implements InstantConsumer
    {
    private static final Logger L = Logger.getLogger(LogTimePartConsumer.class.getName());

    @Override
    public void accept(final Instant instant)
        {
        L.warning("Consume INSTANT => " + instant.toEpochMilli());
        }
    }
