package com.example.pos_webapp.Dto.requestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest {
    private String fullname;
    private String email;
    private String phoneno;
    private String username;
    private String password;
}
