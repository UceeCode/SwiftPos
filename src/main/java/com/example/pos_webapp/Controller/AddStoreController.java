package com.example.pos_webapp.Controller;

import com.example.pos_webapp.Dto.AddStoreRequest;
import com.example.pos_webapp.Dto.AddStoreResponse;
import com.example.pos_webapp.Service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signstore")
@RequiredArgsConstructor
public class AddStoreController {
    private final AddStoreService addStoreService;

    @PostMapping("/savestore")
    public AddStoreResponse saveStore(@RequestBody @Validated AddStoreRequest addStoreRequest) {
        addStoreService.createStore(addStoreRequest);
        return new AddStoreResponse(addStoreRequest.getName());
    }
}
