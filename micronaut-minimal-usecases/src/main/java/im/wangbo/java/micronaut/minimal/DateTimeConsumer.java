package im.wangbo.java.micronaut.minimal;

import java.time.LocalDateTime;
import java.util.function.Consumer;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
interface DateTimeConsumer extends Consumer<LocalDateTime>
    {
    @Override
    void accept(LocalDateTime localDateTime);
    }
