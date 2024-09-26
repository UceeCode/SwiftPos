package com.example.pos_webapp.Controller;

import com.example.pos_webapp.Dto.requestDto.AdminRequest;
import com.example.pos_webapp.Dto.responseDto.AdminResponse;
import com.example.pos_webapp.Model.Admin;
import com.example.pos_webapp.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signadmin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping(name = "/saveadmin")
    public AdminResponse saveAdmin(@RequestBody @Validated AdminRequest adminRequest) {
        adminService.createAdmin(adminRequest);
        return new AdminResponse(adminRequest.getUsername());
    }

    @GetMapping(path = "/getalladmins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }
}
