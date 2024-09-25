package com.example.pos_webapp.Dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddStoreRequest {
    private String name;
    private String manager;
    private String location;
    private String storephoneno;
    private String status;
}
