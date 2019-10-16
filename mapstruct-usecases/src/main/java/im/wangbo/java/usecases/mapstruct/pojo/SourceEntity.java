package im.wangbo.java.usecases.mapstruct.pojo.pojo1to1;

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
public class SourceEntity {

    private int intProperty;

    private boolean boolProperty;

    private Long longProperty;

    private String srtProperty;

    private OffsetDateTime dateTime;

    private List<BigDecimal> numbers;

    private Map<String, TypeEnum> types;

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

    public String getSrtProperty() {
        return srtProperty;
    }

    public void setSrtProperty(String srtProperty) {
        this.srtProperty = srtProperty;
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

    public Map<String, TypeEnum> getTypes() {
        return types;
    }

    public void setTypes(Map<String, TypeEnum> types) {
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
        SourceEntity that = (SourceEntity) o;
        return intProperty == that.intProperty &&
            boolProperty == that.boolProperty &&
            Objects.equals(longProperty, that.longProperty) &&
            Objects.equals(srtProperty, that.srtProperty) &&
            Objects.equals(dateTime, that.dateTime) &&
            Objects.equals(numbers, that.numbers) &&
            Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects
            .hash(intProperty, boolProperty, longProperty, srtProperty, dateTime, numbers, types);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SourceEntity.class.getSimpleName() + "[", "]")
            .add("intProperty=" + intProperty)
            .add("boolProperty=" + boolProperty)
            .add("longProperty=" + longProperty)
            .add("srtProperty='" + srtProperty + "'")
            .add("dateTime=" + dateTime)
            .add("numbers=" + numbers)
            .add("types=" + types)
            .toString();
    }
}
