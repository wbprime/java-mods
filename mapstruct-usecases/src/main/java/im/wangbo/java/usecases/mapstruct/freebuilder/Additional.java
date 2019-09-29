package im.wangbo.java.usecases.mapstruct.freebuilder;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
public class Additional {
    private Integer additionalInt;

    private List<String> additionalList;

    private Map<String, Integer> additionalMap;

    public Integer getAdditionalInt() {
        return additionalInt;
    }

    public void setAdditionalInt(Integer additionalInt) {
        this.additionalInt = additionalInt;
    }

    public List<String> getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(List<String> additionalList) {
        this.additionalList = additionalList;
    }

    public Map<String, Integer> getAdditionalMap() {
        return additionalMap;
    }

    public void setAdditionalMap(Map<String, Integer> additionalMap) {
        this.additionalMap = additionalMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Additional that = (Additional) o;
        return Objects.equals(additionalInt, that.additionalInt) &&
            Objects.equals(additionalList, that.additionalList) &&
            Objects.equals(additionalMap, that.additionalMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalInt, additionalList, additionalMap);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Additional.class.getSimpleName() + "[", "]")
            .add("additionalInt=" + additionalInt)
            .add("additionalList=" + additionalList)
            .add("additionalMap=" + additionalMap)
            .toString();
    }
}
