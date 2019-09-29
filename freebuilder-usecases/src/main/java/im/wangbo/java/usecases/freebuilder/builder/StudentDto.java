package im.wangbo.java.usecases.freebuilder.builder;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import org.inferred.freebuilder.FreeBuilder;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
@FreeBuilder
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

    static Builder builder() {
        return new Builder();
    }

    public static class Builder extends StudentDto_Builder {

        public Builder() {
        }
    }
}
