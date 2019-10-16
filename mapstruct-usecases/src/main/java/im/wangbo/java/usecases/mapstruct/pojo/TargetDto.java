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
public class TargetDto {
    private int intProperty;

    private boolean boolProperty;

    private Long longProperty;

    private String srtProperty;

    private OffsetDateTime dateTime;

    private List<BigDecimal> numberList;

    private Map<String, TypeEnum> typeMap;

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

    public List<BigDecimal> getNumberList() {
        return numberList;
    }

    public void setNumberList(List<BigDecimal> numberList) {
        this.numberList = numberList;
    }

    public Map<String, TypeEnum> getTypeMap() {
        return typeMap;
    }

    public void setTypeMap(Map<String, TypeEnum> typeMap) {
        this.typeMap = typeMap;
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
            Objects.equals(srtProperty, targetDto.srtProperty) &&
            Objects.equals(dateTime, targetDto.dateTime) &&
            Objects.equals(numberList, targetDto.numberList) &&
            Objects.equals(typeMap, targetDto.typeMap);
    }

    @Override
    public int hashCode() {
        return Objects
            .hash(intProperty, boolProperty, longProperty, srtProperty, dateTime, numberList,
                typeMap);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TargetDto.class.getSimpleName() + "[", "]")
            .add("intProperty=" + intProperty)
            .add("boolProperty=" + boolProperty)
            .add("longProperty=" + longProperty)
            .add("srtProperty='" + srtProperty + "'")
            .add("dateTime=" + dateTime)
            .add("numberList=" + numberList)
            .add("typeMap=" + typeMap)
            .toString();
    }
}
