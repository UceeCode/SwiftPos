package com.example.pos_webapp.Service.Implementation;

import com.example.pos_webapp.Dto.requestDto.AddStoreRequest;
import com.example.pos_webapp.Dto.responseDto.AddStoreResponse;
import com.example.pos_webapp.Model.AddStore;
import com.example.pos_webapp.Repositories.AddStoreRepository;
import com.example.pos_webapp.Service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddStoreSeviceImpl implements AddStoreService {
   private final AddStoreRepository addStoreRepository;

   public AddStoreResponse createStore(AddStoreRequest addStoreRequest) {
       AddStore addStore = new AddStore();
       addStore.setName(addStoreRequest.getName());
       addStore.setManager(addStoreRequest.getManager());
       addStore.setLocation(addStoreRequest.getLocation());
       addStore.setStorephoneno(addStoreRequest.getStorephoneno());
       addStore.setStatus(addStoreRequest.getStatus());

       AddStore saveStore = addStoreRepository.save(addStore);

       return new AddStoreResponse(saveStore.getName());
   }
}
