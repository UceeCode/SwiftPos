package com.example.pos_webapp.Dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private String companyName;
    private String companyAddress;
    private String companyphoneno;
    private String companylogo;
    private String companyEmail;
}
