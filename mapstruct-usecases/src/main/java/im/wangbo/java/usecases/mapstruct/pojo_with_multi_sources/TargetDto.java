package im.wangbo.java.usecases.mapstruct.pojo_with_multi_sources;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
public class TargetDto {
    private TypeEnum enumType;
    private String strProperty;
    private OffsetDateTime createTime;
    private OffsetDateTime lastUpdateTime;

    public TypeEnum getEnumType() {
        return enumType;
    }

    public void setEnumType(TypeEnum enumType) {
        this.enumType = enumType;
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

    public OffsetDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(OffsetDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
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
        return enumType == targetDto.enumType &&
            Objects.equals(strProperty, targetDto.strProperty) &&
            Objects.equals(createTime, targetDto.createTime) &&
            Objects.equals(lastUpdateTime, targetDto.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumType, strProperty, createTime, lastUpdateTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TargetDto.class.getSimpleName() + "[", "]")
            .add("enumType=" + enumType)
            .add("strProperty='" + strProperty + "'")
            .add("createTime=" + createTime)
            .add("lastUpdateTime=" + lastUpdateTime)
            .toString();
    }
}
