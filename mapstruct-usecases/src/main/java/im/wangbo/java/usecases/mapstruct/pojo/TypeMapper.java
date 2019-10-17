package im.wangbo.java.usecases.mapstruct.pojo;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * TODO Detail goes here.
 *
 * Created at 2019-10-16 by Elvis Wang
 */
@Mapper(componentModel = "jsr330")
public interface TypeMapper {

    TypeMapper INSTANCE = Mappers.getMapper(TypeMapper.class);

    static TypeMapper instance() {
        return new TypeMapperImpl();
    }

    TargetDto convert(final SourceEntity from);

    SourceEntity convert(final TargetDto from);
}
