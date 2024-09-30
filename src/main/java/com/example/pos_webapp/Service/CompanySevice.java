package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanySevice {
    public CompanyResponse createCompany(CompanyRequest companyRequest);

    List<Company> getAllCompanies();

    Optional<Company> getCompanyById(int id);

    public CompanyResponse updateCompany(int id, CompanyRequest companyRequest);
}
