package com.example.pos_webapp.Service.Implementation;

import com.example.pos_webapp.Dto.requestDto.AddStoreRequest;
import com.example.pos_webapp.Dto.responseDto.AddStoreResponse;
import com.example.pos_webapp.Model.AddStore;
import com.example.pos_webapp.Repositories.AddStoreRepository;
import com.example.pos_webapp.Service.AddStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

   public List<AddStore> getAllStore() {
       return addStoreRepository.findAll();
   }

   public AddStore getStoreById(int store_id) {
       return addStoreRepository.findById(Math.toIntExact(Long.valueOf(store_id))).orElse(null);
   }

   public AddStoreResponse updateStore(int store_id, AddStoreRequest addStoreRequest) {
       AddStore existingStore = getStoreById(store_id);
       existingStore.setName(addStoreRequest.getName());
       existingStore.setManager(addStoreRequest.getManager());
       existingStore.setLocation(addStoreRequest.getLocation());
       existingStore.setStorephoneno(addStoreRequest.getStorephoneno());
       existingStore.setStatus(addStoreRequest.getStatus());
       AddStore saveStore = addStoreRepository.save(existingStore);
       return new AddStoreResponse(saveStore.getName());
   }

   public AddStoreResponse deleteStore(int store_id) {
       AddStore existingStore = getStoreById(store_id);
       addStoreRepository.delete(existingStore);
       return new AddStoreResponse(existingStore.getName() + " has been deleted");
   }
}
