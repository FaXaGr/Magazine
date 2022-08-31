package Magazine.service;

import Magazine.dto.ProductDto;
import Magazine.dto.ResponseDto;
import Magazine.entity.Product;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ProductService {
    void export(HttpServletRequest request, HttpServletResponse response) throws IOException;
    ResponseDto<List<ProductDto>> getAll();
    ResponseDto<List<ProductDto>> getByType(Integer typeId);
    ResponseDto<ProductDto> getById(Integer id);
    ResponseDto<String> add(ProductDto productDto);
    ResponseDto delete(Integer id);
    ResponseDto update(ProductDto productDto);
    ResponseDto<Page<ProductDto>> search(String name,Integer page,Integer size);

}
