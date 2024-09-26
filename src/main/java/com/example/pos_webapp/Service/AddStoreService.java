package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.requestDto.AddStoreRequest;
import com.example.pos_webapp.Dto.responseDto.AddStoreResponse;
import com.example.pos_webapp.Model.AddStore;

import java.util.List;

public interface AddStoreService {
    public AddStoreResponse createStore(AddStoreRequest addStoreRequest);

    public List<AddStore> getAllStore();

    public AddStore getStoreById(int id);
}
