package im.wangbo.java.usecases.mapstruct.pojo.pojo1to1;

import org.mapstruct.Mapper;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
@Mapper
public interface TypeMapper {
    TargetDto convert(final SourceEntity from);

    SourceEntity convert(final TargetDto from);

}
