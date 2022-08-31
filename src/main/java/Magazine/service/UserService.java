package Magazine.service;

import Magazine.dto.ProductDto;
import Magazine.dto.ResponseDto;
import Magazine.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    ResponseDto<List<UserDto>> getAll();
    ResponseDto<UserDto> getById(Integer id);
    ResponseDto<String> add(UserDto userDto);
    ResponseDto<String> update(UserDto userDto);
    ResponseDto<String> deleteById(Integer id);
}
