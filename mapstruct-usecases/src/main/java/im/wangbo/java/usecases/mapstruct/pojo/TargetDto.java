package im.wangbo.java.usecases.mapstruct.pojo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
public class TargetDto {

    private int intProperty;

    private boolean boolProperty;

    private Long longProperty;

    private String strProperty;

    private OffsetDateTime dateTime;

    private List<BigDecimal> numbers;

    private Map<String, String> types;

    public int getIntProperty() {
        return intProperty;
    }

    public void setIntProperty(int intProperty) {
        this.intProperty = intProperty;
    }

    public boolean isBoolProperty() {
        return boolProperty;
    }

    public void setBoolProperty(boolean boolProperty) {
        this.boolProperty = boolProperty;
    }

    public Long getLongProperty() {
        return longProperty;
    }

    public void setLongProperty(Long longProperty) {
        this.longProperty = longProperty;
    }

    public String getStrProperty() {
        return strProperty;
    }

    public void setStrProperty(String strProperty) {
        this.strProperty = strProperty;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<BigDecimal> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<BigDecimal> numbers) {
        this.numbers = numbers;
    }

    public Map<String, String> getTypes() {
        return types;
    }

    public void setTypes(Map<String, String> types) {
        this.types = types;
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
            boolProperty == targetDto.boolProperty &&
            Objects.equals(longProperty, targetDto.longProperty) &&
            Objects.equals(strProperty, targetDto.strProperty) &&
            Objects.equals(dateTime, targetDto.dateTime) &&
            Objects.equals(numbers, targetDto.numbers) &&
            Objects.equals(types, targetDto.types);
    }

    @Override
    public int hashCode() {
        return Objects
            .hash(intProperty, boolProperty, longProperty, strProperty, dateTime, numbers, types);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TargetDto.class.getSimpleName() + "[", "]")
            .add("intProperty=" + intProperty)
            .add("boolProperty=" + boolProperty)
            .add("longProperty=" + longProperty)
            .add("srtProperty='" + strProperty + "'")
            .add("dateTime=" + dateTime)
            .add("numbers=" + numbers)
            .add("types=" + types)
            .toString();
    }
}
