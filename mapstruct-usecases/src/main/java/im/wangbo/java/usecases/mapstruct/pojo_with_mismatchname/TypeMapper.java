package im.wangbo.java.usecases.mapstruct.pojo_with_mismatchname;

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
    TargetDto convert(final SourceEntity from);

    @Mapping(source = "createTime", target = "createdAt")
    SourceEntity convert(final TargetDto from);
}
