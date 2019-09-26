package im.wangbo.java.usecases.mapstruct.bean;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
class UserDto {
    private String name;

    private Gender gender;

    private OffsetDateTime birthday;

    private String addr;

    private List<String> emails;
    private Map<String, Integer> scores;

    private Integer additionalInt;
    private List<String> additionalList;
    private Map<String, Integer> additionalMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }

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
        UserDto dto = (UserDto) o;
        return Objects.equals(name, dto.name) &&
            gender == dto.gender &&
            Objects.equals(birthday, dto.birthday) &&
            Objects.equals(addr, dto.addr) &&
            Objects.equals(emails, dto.emails) &&
            Objects.equals(scores, dto.scores) &&
            Objects.equals(additionalInt, dto.additionalInt) &&
            Objects.equals(additionalList, dto.additionalList) &&
            Objects.equals(additionalMap, dto.additionalMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthday, addr, emails, scores, additionalInt, additionalList, additionalMap);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("gender=" + gender)
            .add("birthday=" + birthday)
            .add("addr='" + addr + "'")
            .add("emails=" + emails)
            .add("scores=" + scores)
            .add("additionalInt=" + additionalInt)
            .add("additionalList=" + additionalList)
            .add("additionalMap=" + additionalMap)
            .toString();
    }
}
