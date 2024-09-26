package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.requestDto.AdminRequest;
import com.example.pos_webapp.Dto.responseDto.AdminResponse;
import com.example.pos_webapp.Model.Admin;

import java.util.List;

public interface AdminService {
    public AdminResponse createAdmin(AdminRequest adminRequest);

    List<Admin> getAllAdmins();
}
