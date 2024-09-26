package com.example.pos_webapp.Controller;

import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Model.Company;
import com.example.pos_webapp.Service.CompanySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanySevice companySevice;

    @PostMapping(name = "/save")
    public CompanyResponse saveCompany(@RequestBody @Validated CompanyRequest companyRequest){
        companySevice.createCompany(companyRequest);

        return new CompanyResponse(companyRequest.getCompanyName());
    }

    @GetMapping(path = "/allcompanies")
    public List<Company> getAllCompany(){
        return companySevice.getAllCompanies();
    }

    @GetMapping(path = "/{company_id}")
    public Optional<Company> getCompanyById(@PathVariable int company_id){
        return companySevice.getCompanyById(company_id);
    }
}
