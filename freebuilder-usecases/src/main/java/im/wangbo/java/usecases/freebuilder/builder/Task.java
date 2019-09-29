package im.wangbo.java.usecases.freebuilder.builder;

import org.inferred.freebuilder.FreeBuilder;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-28, by Elvis Wang
 */
@FreeBuilder
interface Task {

    Long id();

    String type();

    String description();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends Task_Builder {

    }
}
