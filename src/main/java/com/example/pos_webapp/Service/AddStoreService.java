package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.AddStoreRequest;
import com.example.pos_webapp.Dto.AddStoreResponse;

public interface AddStoreService {
    public AddStoreResponse createStore(AddStoreRequest addStoreRequest);
}
