package Magazine.service.Impl;

import Magazine.dto.ResponseDto;
import Magazine.dto.UserDto;
import Magazine.entity.Users;
import Magazine.mapper.UsersMapper;
import Magazine.repository.UsersRepository;
import Magazine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository repository;
    private final UsersMapper mapper;
    @Override
    public ResponseDto<List<UserDto>> getAll() {
        List<Users> users= repository.findAll();
        List<UserDto> userDtoList= users.stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseDto.<List<UserDto>>builder().message("Ok").success(true).code(0).build();
    }

    @Override
    public ResponseDto<UserDto> getById(Integer id) {
        Optional<Users> users= repository.findById(id);
        if(users.isEmpty()) {
            return ResponseDto.<UserDto>builder().code(-1).message("Not found").success(false).build();
        }
        return ResponseDto.<UserDto>builder().message("Ok").success(true).code(0).data(mapper.toDto(users.get())).build();
    }

    @Override
    public ResponseDto<String> add(UserDto userDto) {
        try {
            repository.save(mapper.toEntity(userDto));
            return ResponseDto.<String>builder().message("Ok").success(true).code(0).build();
        }catch (Exception e) {
            return ResponseDto.<String>builder().message("Error").data(e.getMessage()).success(false).code(-3).build();
        }
    }

    @Override
    public ResponseDto<String> update(UserDto userDto) {
        try {
            repository.save(mapper.toEntity(userDto));
            return ResponseDto.<String>builder().message("Ok").success(true).code(0).build();
        }catch (Exception e) {
            return ResponseDto.<String>builder().message("Error").data(e.getMessage()).success(false).code(-3).build();
        }
    }

    @Override
    public ResponseDto<String> deleteById(Integer id) {
        if(!repository.existsById(id)) {
            return ResponseDto.<String>builder().message("Not Found").success(false).code(-3).build();
        }
        repository.deleteById(id);
        return ResponseDto.<String>builder().message("Ok").success(true).code(0).build();
    }
}
