package Magazine.service;

import Magazine.dto.ProductDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

public interface ExcelService {
    void export(Stream<ProductDto> productDtoStream, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
