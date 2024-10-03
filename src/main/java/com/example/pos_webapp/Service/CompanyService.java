package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    CompanyResponse createCompany(CompanyRequest companyRequest);
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(int companyId);
    CompanyResponse updateCompany(int companyId, CompanyRequest companyRequest); // Changed here
    CompanyResponse deleteCompany(int companyId);
    void saveSingleCompany(Company company);
}
