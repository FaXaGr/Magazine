package Magazine.controller;

import Magazine.dto.ResponseDto;
import Magazine.dto.UnitsDto;
import Magazine.service.UnitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/units")
public class UnitsController {
    private final UnitsService service;
    @PostMapping
    public ResponseDto<String> add(@RequestBody UnitsDto unitsDto) {
        return service.add(unitsDto);
    }

}
