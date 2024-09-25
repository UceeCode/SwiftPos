package com.example.pos_webapp.Controller;

import com.example.pos_webapp.Dto.AdminRequest;
import com.example.pos_webapp.Dto.AdminResponse;
import com.example.pos_webapp.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
