package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.AdminRequest;
import com.example.pos_webapp.Dto.AdminResponse;

public interface AdminService {
    public AdminResponse createAdmin(AdminRequest adminRequest);
}
