package im.wangbo.java.usecases.autovalue.builder;

import com.google.auto.value.AutoValue;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import javax.json.bind.annotation.JsonbProperty;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
@AutoValue
abstract class StudentDto {

    public abstract String getName();

    public abstract Level getLevel();

    public abstract OffsetDateTime getBirthday();

    public abstract String getAddr();

    public abstract List<String> getEmails();

    public abstract Map<String, Integer> getScores();

    public abstract Integer getAdditionalInt();

    public abstract List<String> getAdditionalList();

    public abstract Map<String, Integer> getAdditionalMap();

    public static Builder builder() {
        return new AutoValue_StudentDto.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {

        @JsonbProperty
        public abstract Builder setName(String name);

        @JsonbProperty
        public abstract Builder setLevel(Level level);

        @JsonbProperty
        public abstract Builder setBirthday(OffsetDateTime birthday);

        @JsonbProperty

        public abstract Builder setAddr(String addr);

        @JsonbProperty
        public abstract Builder setEmails(List<String> emails);

        @JsonbProperty
        public abstract Builder setScores(Map<String, Integer> scores);

        @JsonbProperty
        public abstract Builder setAdditionalInt(Integer additionalInt);

        @JsonbProperty
        public abstract Builder setAdditionalList(List<String> additionalList);

        @JsonbProperty
        public abstract Builder setAdditionalMap(Map<String, Integer> additionalMap);

        public abstract StudentDto build();
    }
}
