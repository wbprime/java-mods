package im.wangbo.java.usecases.autovalue.builder;

import com.google.auto.value.AutoValue;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-28, by Elvis Wang
 */
@AutoValue
public abstract class Task {
    public abstract Long id();

    public abstract String type();

    public abstract String description();

    public static Task create(Long id, String type, String description) {
        return new AutoValue_Task(id, type, description);
    }
}
