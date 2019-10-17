package im.wangbo.java.usecases.mapstruct.pojo_with_mismatchtype;

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
            Objects.equals(createTime, targetDto.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumType, strProperty, createTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TargetDto.class.getSimpleName() + "[", "]")
            .add("enumType=" + enumType)
            .add("strProperty='" + strProperty + "'")
            .add("createTime=" + createTime)
            .toString();
    }
}
