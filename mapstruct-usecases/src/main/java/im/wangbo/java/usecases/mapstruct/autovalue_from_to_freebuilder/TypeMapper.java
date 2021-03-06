package im.wangbo.java.usecases.mapstruct.autovalue_from_to_freebuilder;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TypeMapper {

    @Mapping(source = "intType", target = "enumType")
    @Mapping(source = "createdAt", target = "createTime")
    TargetDto convert(final SourceEntity from);

    @Mapping(source = "enumType", target = "intType")
    @Mapping(source = "createTime", target = "createdAt")
    SourceEntity convert(final TargetDto from);

    default int mapType(final TypeEnum v) {
        switch (v) {
            case LARGE: return 1;
            case MEDIUM: return 2;
            default: return 3;
        }
    }

    static TypeEnum mapType(final int v) {
        switch (v) {
            case 1: return TypeEnum.LARGE;
            case 2: return TypeEnum.MEDIUM;
            default: return TypeEnum.SMALL;
        }
    }
}
