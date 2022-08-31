package Magazine.service.Impl;

import Magazine.dto.ProductDto;
import Magazine.dto.ResponseDto;
import Magazine.entity.Product;
import Magazine.mapper.ProductMapper;
import Magazine.repository.ProductRepository;
import Magazine.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final Excel excel;
    @Transactional
    @Override
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Stream<Product> productStream = repository.findAllByIdLessThan(1500000);
        Stream<ProductDto> productDtoStream = productStream.map(mapper::toDto);
        excel.export(productDtoStream,request,response);
    }

    @Override
    public ResponseDto<List<ProductDto>> getAll() {
        List<Product> products =  repository.findAll();
        List<ProductDto> productDtoList =  products.stream().map(mapper::toDto).collect(Collectors.toList());
        return ResponseDto.<List<ProductDto>>builder().code(0).message("Success").success(true).data(productDtoList).build();
    }

    @Override
    public ResponseDto<List<ProductDto>> getByType(Integer typeId) {
        List<Product> productList = repository.findAllByProductType_Id(typeId);
        List<ProductDto> productDtoList =  productList.stream().map(mapper::toDto).collect(Collectors.toList());

        return ResponseDto.<List<ProductDto>>builder().code(0).success(true).message("Success").data(productDtoList).build();
    }

    @Override
    public ResponseDto<ProductDto> getById(Integer id) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()) {
            return ResponseDto.<ProductDto>builder().code(-1).success(false).message("Not Found").data(null).build();
        }
        return ResponseDto.<ProductDto>builder()
                .code(0)
                .message("ok")
                .success(true)
                .data(product.map(mapper::toDto).get())
                .build();
    }

    @Override
    public ResponseDto<String> add(ProductDto productDto) {
        Product product = mapper.toEntity(productDto);
        if(!repository.existsById(product.getId())) {
            return ResponseDto.<String>builder().code(-1).success(false).message("This product is already exists").build();
        }
        repository.save(product);
        return ResponseDto.<String>builder().code(0).success(true).message("Success").data(product.toString()).build();
    }

    @Override
    public ResponseDto delete(Integer id) {
        if(!repository.existsById(id)) {
            return ResponseDto.builder().code(-1).success(false).message("Not found").build();
        }
        repository.deleteById(id);
        return ResponseDto.builder().code(0).success(true).message("Success").build();
    }

    @Override
    public ResponseDto update(ProductDto productDto) {
        Product product = mapper.toEntity(productDto);
        if(!repository.existsById(product.getId())) {
            return ResponseDto.builder().code(-1).success(false).message("Not found").build();
        }
        repository.save(product);
        return ResponseDto.builder().code(0).success(true).message("Success").build();
    }

    @Override
    public ResponseDto<Page<ProductDto>> search(String name, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<ProductDto> result = repository.findAllByNameContainingIgnoreCase(name,pageRequest).map(mapper::toDto);

        return ResponseDto.<Page<ProductDto>>builder().code(0).success(false).message("Success").data(result).build();
    }

}
