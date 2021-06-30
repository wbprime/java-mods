package im.wangbo.java.micronaut.minimal;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@Singleton
class LogTimePartConsumer implements DateTimeConsumer
    {
    private static final Logger L = Logger.getLogger(LogTimePartConsumer.class.getName());

    @Override
    public void accept(LocalDateTime dateTime)
        {
        L.warning("Consume TIME => " + dateTime.format(DateTimeFormatter.ISO_TIME));
        }
    }
