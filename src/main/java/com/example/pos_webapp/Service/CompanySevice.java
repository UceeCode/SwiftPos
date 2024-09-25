package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;

public interface CompanySevice {
    public CompanyResponse createCompany(CompanyRequest companyRequest);
}
