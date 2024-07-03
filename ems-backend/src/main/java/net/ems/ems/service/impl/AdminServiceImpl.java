package net.ems.ems.service.impl;

import lombok.AllArgsConstructor;
import net.ems.ems.dto.AdminDto;
import net.ems.ems.entity.Admin;
import net.ems.ems.exception.ResourceNotFoundException;
import net.ems.ems.mapper.AdminMapper;
import net.ems.ems.repository.AdminRepository;
import net.ems.ems.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AdminDto createAdmin(AdminDto adminDto){
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        admin.setPassword(passwordEncoder.encode((admin.getPassword())));
        Admin savedAdmin = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(savedAdmin);
    }

    @Override
    public AdminDto getAdminById(Long adminId){
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id:" + adminId));
        return AdminMapper.mapToAdminDto(admin);
    }

    @Override
    public List<AdminDto> getAllAdmin() {
        return List.of();
    }

    @Override
    public AdminDto updateAdmin(Long adminId, AdminDto updateAdmin) {
        return null;
    }

    @Override
    public void deleteAdmin(Long adminId) {

    }

}
