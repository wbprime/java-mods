package im.wangbo.java.usecases.mapstruct.pojo_with_mismatchname;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
public class TargetDto {
    private int intProperty;

    private String strProperty;

    private OffsetDateTime createTime;

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

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TargetDto targetDto = (TargetDto) o;
        return intProperty == targetDto.intProperty &&
            Objects.equals(strProperty, targetDto.strProperty) &&
            Objects.equals(createTime, targetDto.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intProperty, strProperty, createTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TargetDto.class.getSimpleName() + "[", "]")
            .add("intProperty=" + intProperty)
            .add("strProperty='" + strProperty + "'")
            .add("createTime=" + createTime)
            .toString();
    }
}
