package com.example.pos_webapp.Service.Implementation;

import com.example.pos_webapp.Dto.requestDto.AdminRequest;
import com.example.pos_webapp.Dto.responseDto.AdminResponse;
import com.example.pos_webapp.Model.Admin;
import com.example.pos_webapp.Repositories.AdminRepository;
import com.example.pos_webapp.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminResponse createAdmin(AdminRequest adminRequest) {
        Admin admin = new Admin();
        admin.setFullname(adminRequest.getFullname());
        admin.setEmail(adminRequest.getEmail());
        admin.setPhoneno(adminRequest.getPhoneno());
        admin.setUsername(adminRequest.getUsername());
        admin.setPassword(adminRequest.getPassword());

        Admin saveAdmin = adminRepository.save(admin);

        return new AdminResponse(saveAdmin.getUsername());
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(int admin_id){
        return adminRepository.findById(Math.toIntExact(Long.valueOf(admin_id))).orElse(null);
    }
}
