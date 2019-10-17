package im.wangbo.java.usecases.mapstruct.pojo_with_mismatchname;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
public class SourceEntity {

    private int intProperty;

    private String strProperty;

    private OffsetDateTime createdAt;

    public int getIntProperty() {
        return intProperty;
    }

    public void setIntProperty(int intProperty) {
        this.intProperty = intProperty;
    }

    public String getStrProperty() {
        return strProperty;
    }

    public void setStrProperty(String strProperty) {
        this.strProperty = strProperty;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SourceEntity that = (SourceEntity) o;
        return intProperty == that.intProperty &&
            Objects.equals(strProperty, that.strProperty) &&
            Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intProperty, strProperty, createdAt);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SourceEntity.class.getSimpleName() + "[", "]")
            .add("intProperty=" + intProperty)
            .add("strProperty='" + strProperty + "'")
            .add("createdAt=" + createdAt)
            .toString();
    }
}
