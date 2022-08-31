package Magazine.controller;

import Magazine.dto.ProductTypeDto;
import Magazine.dto.ResponseDto;
import Magazine.service.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productType")
public class ProductTypeController {
    private final ProductTypeService service;

    @GetMapping
    public ResponseDto<List<ProductTypeDto>> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseDto<ProductTypeDto> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseDto<String> add(@RequestBody ProductTypeDto productTypeDto) {
        return service.add(productTypeDto);
    }
    @PatchMapping
    public ResponseDto<String> update(@RequestBody ProductTypeDto productTypeDto) {
        return service.update(productTypeDto);
    }
    @DeleteMapping("/{id}")
    public ResponseDto<String> deleteById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
