package Magazine.service;


import Magazine.dto.ProductTypeDto;
import Magazine.dto.ResponseDto;

import java.util.List;

public interface ProductTypeService {
    ResponseDto<List<ProductTypeDto>> getAll();
    ResponseDto<ProductTypeDto> getById(Integer id);
    ResponseDto<String> add(ProductTypeDto productTypeDto);
    ResponseDto<String> update(ProductTypeDto productTypeDto);
    ResponseDto<String> deleteById(Integer id);
}
