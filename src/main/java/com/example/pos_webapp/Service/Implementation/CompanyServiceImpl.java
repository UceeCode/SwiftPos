package com.example.pos_webapp.Service.Implementation;

import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Model.Company;
import com.example.pos_webapp.Repositories.CompanyRepository;
import com.example.pos_webapp.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    // Method to create a new company
    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setCompany_email(companyRequest.getCompanyEmail());
        company.setCompany_name(companyRequest.getCompanyName());
        company.setCompany_address(companyRequest.getCompanyAddress());
        company.setCompany_logo(companyRequest.getCompanylogo());
        company.setCompany_phoneno(companyRequest.getCompanyphoneno());

        Company savedCompany = companyRepository.save(company);

        return new CompanyResponse(savedCompany.getCompany_name());
    }

    // Method to retrieve all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Method to retrieve a company by its ID
    public Optional<Company> getCompanyById(int companyId) {
        return companyRepository.findById((long) companyId);
    }


    // Method to update an existing company
    public CompanyResponse updateCompany(int companyId, CompanyRequest companyRequest) {
        Optional<Company> companyOptional = companyRepository.findById((long) companyId);
        if (companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();
            existingCompany.setCompany_email(companyRequest.getCompanyEmail());
            existingCompany.setCompany_name(companyRequest.getCompanyName());
            existingCompany.setCompany_address(companyRequest.getCompanyAddress());
            existingCompany.setCompany_logo(companyRequest.getCompanylogo());
            existingCompany.setCompany_phoneno(companyRequest.getCompanyphoneno());

            Company updatedCompany = companyRepository.save(existingCompany);
            return new CompanyResponse(updatedCompany.getCompany_name());
        } else {
            throw new IllegalArgumentException("Company not found with ID: " + companyId);
        }
    }

    // Method to delete a company
    public CompanyResponse deleteCompany(int companyId) {
        Optional<Company> companyOptional = companyRepository.findById((long) companyId);
        if (companyOptional.isPresent()) {
            Company existingCompany = companyOptional.get();
            companyRepository.delete(existingCompany);
            return new CompanyResponse(existingCompany.getCompany_name() + " Deleted");
        } else {
            throw new IllegalArgumentException("Company not found with ID: " + companyId);
        }
    }

    // Method to save a single company
    public void saveSingleCompany(Company company) {
        companyRepository.save(company);
    }
}
