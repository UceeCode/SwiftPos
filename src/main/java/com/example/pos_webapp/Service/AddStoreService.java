package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.requestDto.AddStoreRequest;
import com.example.pos_webapp.Dto.responseDto.AddStoreResponse;

public interface AddStoreService {
    public AddStoreResponse createStore(AddStoreRequest addStoreRequest);
}
