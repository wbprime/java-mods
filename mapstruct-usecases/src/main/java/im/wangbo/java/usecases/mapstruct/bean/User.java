package im.wangbo.java.usecases.mapstruct.bean;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
class User {
    private String name;

    private int gender;

    private long birthdayInMillis;

    private String addr;

    private List<String> emails;
    private Map<String, Integer> scores;

    private String ignoredStr;
    private List<String> ignoredList;
    private Map<String, Integer> ignoredMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public long getBirthdayInMillis() {
        return birthdayInMillis;
    }

    public void setBirthdayInMillis(long birthdayInMillis) {
        this.birthdayInMillis = birthdayInMillis;
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

    public String getIgnoredStr() {
        return ignoredStr;
    }

    public void setIgnoredStr(String ignoredStr) {
        this.ignoredStr = ignoredStr;
    }

    public List<String> getIgnoredList() {
        return ignoredList;
    }

    public void setIgnoredList(List<String> ignoredList) {
        this.ignoredList = ignoredList;
    }

    public Map<String, Integer> getIgnoredMap() {
        return ignoredMap;
    }

    public void setIgnoredMap(Map<String, Integer> ignoredMap) {
        this.ignoredMap = ignoredMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return gender == user.gender &&
            birthdayInMillis == user.birthdayInMillis &&
            Objects.equals(name, user.name) &&
            Objects.equals(addr, user.addr) &&
            Objects.equals(emails, user.emails) &&
            Objects.equals(scores, user.scores) &&
            Objects.equals(ignoredStr, user.ignoredStr) &&
            Objects.equals(ignoredList, user.ignoredList) &&
            Objects.equals(ignoredMap, user.ignoredMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthdayInMillis, addr, emails, scores, ignoredStr, ignoredList, ignoredMap);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("gender=" + gender)
            .add("birthdayInMillis=" + birthdayInMillis)
            .add("addr='" + addr + "'")
            .add("emails=" + emails)
            .add("scores=" + scores)
            .add("ignoredStr='" + ignoredStr + "'")
            .add("ignoredList=" + ignoredList)
            .add("ignoredMap=" + ignoredMap)
            .toString();
    }
}
