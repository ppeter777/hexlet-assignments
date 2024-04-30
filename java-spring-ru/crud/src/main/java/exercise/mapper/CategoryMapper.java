package exercise.mapper;

import exercise.dto.CategoryCreateDTO;
import exercise.dto.CategoryDTO;
import exercise.dto.ProductCreateDTO;
import exercise.model.Category;
import exercise.model.Product;
import org.mapstruct.*;

// BEGIN
@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class CategoryMapper {
//@Mapping(target = "category.id", source = "category")
    public abstract Category map(CategoryCreateDTO dto);
    public abstract CategoryDTO map(Category model);
}
// END
