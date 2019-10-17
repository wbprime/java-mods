package im.wangbo.java.usecases.mapstruct.pojo_with_multi_sources;

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

    @Mapping(source = "from.intType", target = "enumType")
    @Mapping(source = "from.createdAt", target = "createTime")
    @Mapping(source = "additional.updatedAt", target = "lastUpdateTime")
    TargetDto convert(final SourceEntity from, final AdditionalEntity additional);

    @Mapping(source = "enumType", target = "intType")
    @Mapping(source = "createTime", target = "createdAt")
    SourceEntity convertToSource(final TargetDto from);

    @Mapping(source = "lastUpdateTime", target = "updatedAt")
    @Mapping(target = "updatedBy", constant = "System")
    @Mapping(target = "content", expression = "java(\"Created at \" + java.time.OffsetDateTime.now())")
    AdditionalEntity convertToAdditional(final TargetDto from);

    default int mapType(final TypeEnum v) {
        switch (v) {
            case LARGE:
                return 1;
            case MEDIUM:
                return 2;
            default:
                return 3;
        }
    }

    static TypeEnum mapType(final int v) {
        switch (v) {
            case 1:
                return TypeEnum.LARGE;
            case 2:
                return TypeEnum.MEDIUM;
            default:
                return TypeEnum.SMALL;
        }
    }
}
