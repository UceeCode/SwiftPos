package com.example.pos_webapp.Controller;

import org.springframework.ui.Model;
import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Model.Company;
import com.example.pos_webapp.Service.CompanyService; // Fixed typo from 'CompanySevice'
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    // Show the addcompany.html form
    @GetMapping("/addcompany")
    public String showAddCompanyForm(Model model) {
        model.addAttribute("company", new Company()); // Passing a blank Company object to bind form fields
        return "addcompany"; // This will render addcompany.html
    }

    // Handle the form submission and save the company
    @PostMapping("/saveSingle")
    public String saveSingleCompany(@ModelAttribute Company company, Model model) {
        companyService.saveSingleCompany(company);
        model.addAttribute("addcompany", "Company saved successfully!");
        return "addcompany"; // After saving, show the addcompany form again
    }

    @PostMapping("/save") // Corrected name parameter, removed unnecessary 'name' attribute
    public CompanyResponse saveCompany(@RequestBody @Validated CompanyRequest companyRequest) {
        companyService.createCompany(companyRequest);
        return new CompanyResponse(companyRequest.getCompanyName());
    }

    @GetMapping(path = "/allcompanies")
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "companies"; // This will render the companies.html view
    }

    @GetMapping(path = "/{company_id}")
    public Optional<Company> getCompanyById(@PathVariable int company_id) {
        return companyService.getCompanyById(company_id);
    }

    @PutMapping("/{id}")
    public CompanyResponse updateCompany(@PathVariable int id, @RequestBody @Validated CompanyRequest companyRequest) {
        companyService.updateCompany(id, companyRequest);
        return new CompanyResponse(companyRequest.getCompanyName());
    }

    @DeleteMapping("/{id}")
    public CompanyResponse deleteCompany(@PathVariable int id) {
        return companyService.deleteCompany(id);
    }
}
