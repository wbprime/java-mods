package im.wangbo.java.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import java.util.logging.Logger;

public class Application
    {
    private static final Logger L = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) throws Exception
        {
        try (final ApplicationContext context = Micronaut.run(Application.class, args))
            {
            {
            final JdbiRepository repository = context.getBean(JdbiRepository.class);

            final int count = repository.countUsers1();
            L.info(() -> String.format("Result => %d", count));
            }

            }

        L.info("Application exited !!!");
        }
    }
