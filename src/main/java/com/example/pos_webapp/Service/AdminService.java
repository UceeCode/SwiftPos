package com.example.pos_webapp.Service;

import com.example.pos_webapp.Dto.requestDto.AdminRequest;
import com.example.pos_webapp.Dto.responseDto.AdminResponse;

public interface AdminService {
    public AdminResponse createAdmin(AdminRequest adminRequest);
}
