package im.wangbo.java.usecases.mapstruct.autovalue_from_to_freebuilder;

import java.time.OffsetDateTime;
import org.inferred.freebuilder.FreeBuilder;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
@FreeBuilder
public abstract class TargetDto {
    public abstract TypeEnum getEnumType();
    public abstract String getStrProperty();
    public abstract OffsetDateTime getCreateTime();

    public static Builder builder() {
        return new Builder();
    }

    static class Builder extends TargetDto_Builder { }
}
