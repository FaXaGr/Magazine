package Magazine.mapper;

import Magazine.dto.ProductDto;
import Magazine.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto productDto);
    ProductDto toDto(Product product);
}
