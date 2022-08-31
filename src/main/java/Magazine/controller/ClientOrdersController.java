package Magazine.controller;

import Magazine.service.ClientOrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class ClientOrdersController {
    private final ClientOrdersService service;
}
