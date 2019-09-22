package im.wangbo.java.usecases.mapstruct.bean;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * TODO more details here.
 * <p>
 * Created at 2019-09-22, by Elvis Wang
 */
@Mapper
interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mapping(source = "birthdayInMillis", target = "birthday")
    UserDto convert(final User e);

    @Mapping(source = "birthday", target = "birthdayInMillis")
    User convert(final UserDto e);

    static long offsetDateTimeToMillis(final OffsetDateTime dt) {
        return dt.toInstant().toEpochMilli();
    }

    static OffsetDateTime offsetDateTimeFromMillis(final long millis) {
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneOffset.ofHours(8));
    }

    static Gender mapGender(final int v) {
        switch (v) {
            case 1:
                return Gender.MALE;
            case 0:
                return Gender.FEMALE;
            default:
                throw new IllegalArgumentException("Unexpected value to Gender: " + v);
        }
    }

    static int mapGender(final Gender g) {
        switch (g) {
            case MALE:
                return 1;
            case FEMALE:
                return 0;
            default:
                throw new IllegalArgumentException("Unexpected value from Gender " + g);
        }
    }
}
