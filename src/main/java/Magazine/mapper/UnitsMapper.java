package Magazine.mapper;

import Magazine.dto.UnitsDto;
import Magazine.entity.Units;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitsMapper {
    Units toEntity(UnitsDto unitsDto);
    UnitsDto toDto(Units units);
}
