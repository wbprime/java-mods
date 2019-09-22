package im.wangbo.java.usecases.mapstruct.builder;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
class StudentDtoMapperTest {
    @Test
    void testUserToUserDto() {
        final String name = "name";
        final Level level = Level.GOOD;
        final String addr = "addr";
        final OffsetDateTime birthday = OffsetDateTime.now();
        final List<String> emails = Collections.singletonList("a@b.com");
        final Map<String, Integer> scores = Collections.singletonMap("Math", 80);

        final String ignoredStr = "18330";
        final List<String> ignoredList = Collections.singletonList("ahdsfashdk");
        final Map<String, Integer> ignoredMap = Collections.singletonMap("hdsfjka", 80);

        final Integer addInt = 100;
        final List<String> addList = Collections.singletonList("ahdsfashdk");
        final Map<String, Integer> addMap = Collections.singletonMap("hdsfjka", 80);

        final StudentDtoMapper mapper = StudentDtoMapper.INSTANCE;

        final Student entity = new Student();
        entity.setName(name);
        entity.setLevel(StudentDtoMapper.level(level));
        entity.setAddr(addr);
        entity.setBirthdayInMillis(birthday.toInstant().toEpochMilli());
        entity.setEmails(emails);
        entity.setScores(scores);
        entity.setIgnoredStr(ignoredStr);
        entity.setIgnoredList(ignoredList);
        entity.setIgnoredMap(ignoredMap);

        final Additional additional = new Additional();
        additional.setAdditionalInt(addInt);
        additional.setAdditionalList(addList);
        additional.setAdditionalMap(addMap);

        final StudentDto dto = mapper.convert(entity, additional);

        assertThat(dto).isNotNull();
        assertThat(dto.getAddr()).isEqualTo(addr);
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getLevel()).isEqualTo(level);
        assertThat(dto.getBirthday()).isEqualTo(birthday);
        assertWithMessage("emails expected equal")
            .that(dto.getEmails())
            .isEqualTo(emails);
        assertWithMessage("emails expected not same instance")
            .that(dto.getEmails())
            .isNotSameInstanceAs(emails);
        assertWithMessage("scores expected equal")
            .that(dto.getScores())
            .isEqualTo(scores);
        assertWithMessage("scores expected not same instance")
            .that(dto.getScores())
            .isNotSameInstanceAs(scores);
        assertThat(dto.getAdditionalInt()).isEqualTo(addInt);
        assertThat(dto.getAdditionalList()).isEqualTo(addList);
        assertThat(dto.getAdditionalMap()).isEqualTo(addMap);
    }

    @Test
    void testUserDtoToUser() {
        final String name = "name";
        final Level level = Level.GOOD;
        final String addr = "addr";
        final OffsetDateTime birthday = OffsetDateTime.now();
        final List<String> emails = Collections.singletonList("a@b.com");
        final Map<String, Integer> scores = Collections.singletonMap("Math", 80);

        final Integer addInt = 100;
        final List<String> addList = Collections.singletonList("ahdsfashdk");
        final Map<String, Integer> addMap = Collections.singletonMap("hdsfjka", 80);

        final StudentDtoMapper mapper = StudentDtoMapper.INSTANCE;

        final StudentDto dto = StudentDto.builder()
            .setName(name)
            .setLevel(level)
            .setAddr(addr)
            .setBirthday(birthday)
            .setEmails(emails)
            .setScores(scores)
            .setAdditionalInt(addInt)
            .setAdditionalList(addList)
            .setAdditionalMap(addMap)
            .build();

        final Student entity = mapper.convert(dto);

        assertThat(entity).isNotNull();
        assertThat(entity.getAddr()).isEqualTo(addr);
        assertThat(entity.getName()).isEqualTo(name);
        assertThat(entity.getLevel()).isEqualTo(StudentDtoMapper.level(level));
        assertThat(entity.getBirthdayInMillis()).isEqualTo(birthday.toInstant().toEpochMilli());
        assertWithMessage("emails expected equal")
            .that(entity.getEmails())
            .isEqualTo(emails);
        assertWithMessage("emails expected not same instance")
            .that(entity.getEmails())
            .isNotSameInstanceAs(emails);
        assertWithMessage("scores expected equal")
            .that(entity.getScores())
            .isEqualTo(scores);
        assertWithMessage("scores expected not same instance")
            .that(entity.getScores())
            .isNotSameInstanceAs(scores);
        assertThat(entity.getIgnoredStr()).isNull();
        assertThat(entity.getIgnoredList()).isNull();
        assertThat(entity.getIgnoredMap()).isNull();
    }
}
