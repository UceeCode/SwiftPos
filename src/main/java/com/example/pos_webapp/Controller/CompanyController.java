package com.example.pos_webapp.Controller;

import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Service.CompanySevice;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
