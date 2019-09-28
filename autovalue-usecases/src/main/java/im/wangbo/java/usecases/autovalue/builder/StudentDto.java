package im.wangbo.java.usecases.autovalue.builder;

import com.google.auto.value.AutoValue;

import javax.json.bind.annotation.JsonbCreator;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
@AutoValue
public abstract class StudentDto {

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
    public abstract static class Builder {
        @JsonbCreator
        public static StudentDto.Builder builder() {
            return new AutoValue_StudentDto.Builder();
        }

        public abstract Builder setName(String name);

        public abstract Builder setLevel(Level level);

        public abstract Builder setBirthday(OffsetDateTime birthday);

        public abstract Builder setAddr(String addr);

        public abstract Builder setEmails(List<String> emails);

        public abstract Builder setScores(Map<String, Integer> scores);

        public abstract Builder setAdditionalInt(Integer additionalInt);

        public abstract Builder setAdditionalList(List<String> additionalList);

        public abstract Builder setAdditionalMap(Map<String, Integer> additionalMap);

        public abstract StudentDto build();
    }
}
