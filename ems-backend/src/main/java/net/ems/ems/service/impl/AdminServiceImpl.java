package net.ems.ems.service.impl;

import net.ems.ems.dto.AdminDto;
import net.ems.ems.entity.Admin;
import net.ems.ems.mapper.AdminMapper;
import net.ems.ems.repository.AdminRepository;
import net.ems.ems.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    public AdminDto createAdmin(AdminDto adminDto){
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        admin.setPassword(passwordEncoder.encode((admin.getPassword())));
        Admin savedAdmin = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(savedAdmin);
    }

}
