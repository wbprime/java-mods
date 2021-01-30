package im.wangbo.java.usecases.quickfixj;

import com.google.auto.value.AutoValue;

import java.util.Optional;

@AutoValue
abstract class SessionId {
    abstract String beginString();

    abstract String senderCompID();

    abstract Optional<String> senderSubID();

    abstract Optional<String> senderLocationID();

    abstract String targetCompID();

    abstract Optional<String> targetSubID();

    abstract Optional<String> targetLocationID();

    abstract Optional<String> sessionQualifier();

    public static Builder fix44Builder() {
        return builder().beginString("FIX.4.4");
    }

    public static Builder builder() {
        return new AutoValue_SessionId.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder beginString(String beginString);

        public abstract Builder senderCompID(String senderCompID);

        public abstract Builder senderSubID(Optional<String> senderSubID);

        public abstract Builder senderLocationID(Optional<String> senderLocationID);

        public abstract Builder targetCompID(String targetCompID);

        public abstract Builder targetSubID(Optional<String> targetSubID);

        public abstract Builder targetLocationID(Optional<String> targetLocationID);

        public abstract Builder sessionQualifier(Optional<String> sessionQualifier);

        public abstract SessionId build();
    }
}
