package com.example.pos_webapp.Controller;

import org.springframework.ui.Model;
import com.example.pos_webapp.Dto.requestDto.CompanyRequest;
import com.example.pos_webapp.Dto.responseDto.CompanyResponse;
import com.example.pos_webapp.Model.Company;
import com.example.pos_webapp.Service.CompanyService;
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
        model.addAttribute("company", new Company());
        return "addcompany";
    }

    // Show updatecompany.html form
    @GetMapping("/updatecompany/{company_id}")
    public String showUpdateForm(@PathVariable int company_id, Model model) {
        Optional<Company> company = companyService.getCompanyById(company_id);
        if (company.isPresent()) {
            model.addAttribute("company", company.get());
            return "update";
        }
        return "redirect:/register/allcompanies";
    }

    // Handle the form submission and save the company
    @PostMapping("/saveSingle")
    public String saveSingleCompany(@ModelAttribute Company company, Model model) {
        companyService.saveSingleCompany(company);
        model.addAttribute("addcompany", "Company saved successfully!");
        return "redirect:/register/allcompanies";
    }

    @PostMapping("/save")
    public CompanyResponse saveCompany(@RequestBody @Validated CompanyRequest companyRequest) {
        companyService.createCompany(companyRequest);
        return new CompanyResponse(companyRequest.getCompanyName());
    }

    @GetMapping(path = "/allcompanies")
    public String getAllCompanies(Model model) {
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "companies";
    }

    @GetMapping(path = "/{company_id}")
    public Optional<Company> getCompanyById(@PathVariable int company_id) {
        return companyService.getCompanyById(company_id);
    }

    // Handle the form submission for updating a company
    @PostMapping("/update")
    public String updateCompany(@ModelAttribute Company company, Model model) {
        CompanyRequest companyRequest = new CompanyRequest();
        companyRequest.setCompanyName(company.getCompany_name());
        companyRequest.setCompanyAddress(company.getCompany_address());
        companyRequest.setCompanyphoneno(company.getCompany_phoneno());
        companyRequest.setCompanylogo(company.getCompany_logo());
        companyRequest.setCompanyEmail(company.getCompany_email());

        companyService.updateCompany(company.getCompany_id(), companyRequest);

        model.addAttribute("updateMessage", "Company updated successfully!");
        return "redirect:/register/allcompanies";
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable int id, Model model) {
        companyService.deleteCompany(id);
        model.addAttribute("deleteMessage", "Company deleted successfully!");
        return "redirect:/register/allcompanies";
    }
}
