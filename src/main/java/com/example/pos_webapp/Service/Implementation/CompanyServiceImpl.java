package com.example.pos_webapp.Service.Implementation;

import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Model.Company;
import com.example.pos_webapp.Repositories.CompanyRepository;
import com.example.pos_webapp.Service.CompanySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanySevice {

    private final CompanyRepository companyRepository;


    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setCompany_email(companyRequest.getCompanyEmail());
        company.setCompany_name(companyRequest.getCompanyName());
        company.setCompany_address(companyRequest.getCompanyAddress());
        company.setCompany_logo(companyRequest.getCompanylogo());
        company.setCompany_phoneno(companyRequest.getCompanyphoneno());

        Company saveCompany = companyRepository.save(company);

        return new CompanyResponse(saveCompany.getCompany_name());
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(int company_id) {
        return Optional.ofNullable(companyRepository.findById(Long.valueOf(company_id)).orElse(null));
    }
}
