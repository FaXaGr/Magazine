package Magazine.mapper;

import Magazine.dto.OrdersProductDto;
import Magazine.entity.OrdersProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersProductMapper {
    OrdersProduct toEntity(OrdersProductDto ordersProductDto);
    OrdersProductDto toDto(OrdersProduct ordersProduct);
}
