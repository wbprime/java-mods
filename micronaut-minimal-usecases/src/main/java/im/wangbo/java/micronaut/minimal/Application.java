package im.wangbo.java.micronaut.minimal;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import java.time.Clock;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class Application
    {
    private static final Logger L = Logger.getLogger(Application.class.getName());
    public static final String FLAG = "io.wangbo.micronaut.flag";

    public static void main(String[] args)
        {
        // To help test Optional injection
        System.setProperty(FLAG, String.valueOf(ThreadLocalRandom.current().nextBoolean()));

        try (final ApplicationContext context = Micronaut.build(args)
            .mainClass(Application.class)
            .singletons(Clock.systemDefaultZone())
            .start())
            {
            {
            final DateTimeService service = context.getBean(DateTimeService.class);
            service.action();
            }
            {
            final InstantService service = context.getBean(InstantService.class);
            service.action();
            }
            }
        }
    }
