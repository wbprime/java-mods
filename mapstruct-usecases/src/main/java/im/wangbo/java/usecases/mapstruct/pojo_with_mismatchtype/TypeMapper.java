package im.wangbo.java.usecases.mapstruct.pojo_with_mismatchtype;

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

    @Mapping(source = "createdAt", target = "createTime")
    @Mapping(source = "intType", target = "enumType")
    TargetDto convert(final SourceEntity from);

    @Mapping(source = "createTime", target = "createdAt")
    @Mapping(source = "enumType", target = "intType")
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
