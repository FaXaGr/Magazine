package Magazine.controller;

import Magazine.dto.ProductDto;
import Magazine.dto.ResponseDto;
import Magazine.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;
    @GetMapping("/export")
    public void exportFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.export(request,response);
    }
    @GetMapping
    public ResponseDto<List<ProductDto>> getAll() {
        return service.getAll();
    }

    public ResponseDto<List<ProductDto>> getByType(Integer typeId) {
        return service.getByType(typeId);
    }

    @GetMapping("/{id}")
    public ResponseDto<ProductDto> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseDto<String> add(@RequestBody ProductDto productDto) {
        return service.add(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @PatchMapping
    public ResponseDto update(@RequestBody ProductDto productDto) {
        return service.update(productDto);
    }
    public ResponseDto<Page<ProductDto>> search(String name, Integer page, Integer size) {
        return service.search(name,page,size);
    }

}
