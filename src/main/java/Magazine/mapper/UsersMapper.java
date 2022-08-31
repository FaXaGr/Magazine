package Magazine.mapper;

import Magazine.dto.UserDto;
import Magazine.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users toEntity(UserDto userDto);
    UserDto toDto(Users user);
}
