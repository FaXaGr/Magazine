package Magazine.service.Impl;

import Magazine.dto.ProductTypeDto;
import Magazine.dto.ResponseDto;
import Magazine.entity.ProductType;
import Magazine.mapper.ProductTypeMapper;
import Magazine.repository.ProductTypeRepository;
import Magazine.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository repository;
    private final ProductTypeMapper mapper;
    @Override
    public ResponseDto<List<ProductTypeDto>> getAll() {
        List<ProductType> types = repository.findAll();
        List<ProductTypeDto> dtoList= types.stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseDto.<List<ProductTypeDto>>builder().message("Success").data(dtoList).code(0).build();
    }

    @Override
    public ResponseDto<ProductTypeDto> getById(Integer id) {
        Optional<ProductType> productType = repository.findById(id);
        if(productType.isEmpty()) {
            return ResponseDto.<ProductTypeDto>builder().message("Not found").success(false).code(-1).build();
        }
        return ResponseDto.<ProductTypeDto>builder()
                .message("Ok")
                .success(true)
                .code(0)
                .data(productType.map(mapper::toDto).get())
                .build();
    }

    @Override
    public ResponseDto<String> add(ProductTypeDto productTypeDto) {
        try {
            repository.save(mapper.toEntity(productTypeDto));
            return ResponseDto.<String>builder()
                    .message("ok")
                    .success(true)
                    .code(0)
                    .build();
        } catch (Exception e) {
            return ResponseDto.<String>builder()
                    .success(false)
                    .message(e.getMessage())
                    .code(-2).build();
        }


    }

    @Override
    public ResponseDto<String> update(ProductTypeDto productTypeDto) {
        repository.save(mapper.toEntity(productTypeDto));
        return ResponseDto.<String>builder().message("Ok").success(true).code(0).build();
    }

    @Override
    public ResponseDto<String> deleteById(Integer id) {
        if(!repository.existsById(id)) {
            return ResponseDto.<String>builder()
                    .message("Not Found")
                    .success(false)
                    .code(-3).build();
        }
        repository.deleteById(id);
        return ResponseDto.<String>builder()
                .message("Ok")
                .success(true)
                .code(-1).build();
    }
}
