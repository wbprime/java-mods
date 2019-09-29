package im.wangbo.java.usecases.mapstruct.freebuilder;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
@Mapper
interface StudentDtoMapper {

    StudentDtoMapper INSTANCE = Mappers.getMapper(StudentDtoMapper.class);

    @Mapping(source = "e.birthdayInMillis", target = "birthday")
    StudentDto convert(final Student e, final Additional a);

    @Mapping(source = "birthday", target = "birthdayInMillis")
    Student convert(final StudentDto e);

    static long offsetDateTimeToMillis(final OffsetDateTime dt) {
        return dt.toInstant().toEpochMilli();
    }

    static OffsetDateTime offsetDateTimeFromMillis(final long millis) {
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneOffset.ofHours(8));
    }

    static Level level(final int v) {
        switch (v) {
            case 100:
                return Level.PERFECT;
            case 60:
                return Level.GOOD;
            case 0:
                return Level.BAD;
            default:
                throw new IllegalArgumentException("Unexpected value to Level: " + v);
        }
    }

    static int level(final Level g) {
        switch (g) {
            case PERFECT:
                return 100;
            case GOOD:
                return 60;
            case BAD:
                return 0;
            default:
                throw new IllegalArgumentException("Unexpected value from Level " + g);
        }
    }
}
