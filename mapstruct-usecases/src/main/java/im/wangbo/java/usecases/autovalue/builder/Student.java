package im.wangbo.java.usecases.mapstruct.builder;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
class Student {
    private String name;

    private int level;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
        Student student = (Student) o;
        return level == student.level &&
            birthdayInMillis == student.birthdayInMillis &&
            Objects.equals(name, student.name) &&
            Objects.equals(addr, student.addr) &&
            Objects.equals(emails, student.emails) &&
            Objects.equals(scores, student.scores) &&
            Objects.equals(ignoredStr, student.ignoredStr) &&
            Objects.equals(ignoredList, student.ignoredList) &&
            Objects.equals(ignoredMap, student.ignoredMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, birthdayInMillis, addr, emails, scores, ignoredStr, ignoredList, ignoredMap);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("level=" + level)
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
