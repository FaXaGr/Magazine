package Magazine.mapper;

import Magazine.dto.ClientOrdersDto;
import Magazine.entity.ClientOrders;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientOrdersMapper {
    ClientOrders toEntity(ClientOrdersDto clientOrdersDto);
    ClientOrdersDto toDto(ClientOrders clientOrders);
}
