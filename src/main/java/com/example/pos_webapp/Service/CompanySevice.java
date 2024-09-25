package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.CompanyRequest;
import com.example.pos_webapp.Dto.CompanyResponse;

public interface CompanySevice {
    public CompanyResponse createCompany(CompanyRequest companyRequest);
}
