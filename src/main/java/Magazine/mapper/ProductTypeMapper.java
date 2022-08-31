package Magazine.mapper;

import Magazine.dto.ProductTypeDto;
import Magazine.entity.ProductType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductTypeMapper {
    ProductType toEntity(ProductTypeDto productTypeDto);
    ProductTypeDto toDto(ProductType productType);
}
