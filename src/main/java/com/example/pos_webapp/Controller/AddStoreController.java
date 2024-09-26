package com.example.pos_webapp.Controller;

import com.example.pos_webapp.Dto.requestDto.AddStoreRequest;
import com.example.pos_webapp.Dto.responseDto.AddStoreResponse;
import com.example.pos_webapp.Model.AddStore;
import com.example.pos_webapp.Service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/getallstore")
    public List<AddStore> getAllStore() {
        return addStoreService.getAllStore();
    }

    @GetMapping(path = "/{store_id}")
    public AddStore getStoreById(@PathVariable int store_id) {
        return addStoreService.getStoreById(store_id);
    }

}
