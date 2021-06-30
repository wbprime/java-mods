package im.wangbo.java.micronaut.validation;

import javax.inject.Singleton;
import javax.validation.Valid;
import java.util.logging.Logger;

/**
 * TODO add description here.
 *
 * @author Elvis Wang
 * @since 1.0.0
 */
@Singleton
class SimpleService
    {
    private static final Logger L = Logger.getLogger(SimpleService.class.getName());

    public void action(@Valid final SimpleDto dto)
        {
        L.warning("Action for " + dto);
        }
    }
