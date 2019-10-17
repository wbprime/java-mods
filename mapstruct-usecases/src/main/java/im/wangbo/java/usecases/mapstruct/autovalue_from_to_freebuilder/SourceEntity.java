package im.wangbo.java.usecases.mapstruct.autovalue_from_to_freebuilder;

import com.google.auto.value.AutoValue;
import java.time.OffsetDateTime;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
@AutoValue
public abstract class SourceEntity {
    public abstract int getIntType();
    public abstract String getStrProperty();
    public abstract OffsetDateTime getCreatedAt();

    public static Builder builder() {
        return new AutoValue_SourceEntity.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setIntType(int newIntType);
        public abstract Builder setStrProperty(String newStrProperty);
        public abstract Builder setCreatedAt(OffsetDateTime newCreatedAt);

        public abstract SourceEntity build();
    }
}
