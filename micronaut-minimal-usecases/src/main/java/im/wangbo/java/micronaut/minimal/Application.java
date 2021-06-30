package im.wangbo.java.micronaut.minimal;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import java.time.Clock;
import java.util.logging.Logger;

public class Application
    {
    private static final Logger L = Logger.getLogger(Application.class.getName());

    public static void main(String[] args)
        {
        try (final ApplicationContext context = Micronaut.build(args)
            .mainClass(Application.class)
            .singletons(Clock.systemDefaultZone())
            .start())
            {
            final ActionService service = context.getBean(ActionService.class);
            service.action();
            }
        }
    }
