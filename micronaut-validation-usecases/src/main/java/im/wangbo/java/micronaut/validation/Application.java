package im.wangbo.java.micronaut.validation;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import java.util.Collections;
import java.util.logging.Logger;

public class Application
    {
    private static final Logger L = Logger.getLogger(Application.class.getName());

    public static void main(String[] args)
        {
        try (final ApplicationContext context = Micronaut.run(Application.class, args))
            {
            final SimpleService service = context.getBean(SimpleService.class);

            final SimpleDto dto = new SimpleDto();
//            dto.setVal1(101);
            dto.setVal1(1);
            dto.setVal2("");
//            dto.setVal2("a");
//            dto.setVal3(Collections.singletonList("b"));
            dto.setVal3(Collections.singletonList(""));
//            dto.setVal3(Collections.emptyList());
            service.action(dto);
            }
        }
    }
