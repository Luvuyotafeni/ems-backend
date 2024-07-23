package net.ems.ems.service.impl;

import lombok.AllArgsConstructor;
import net.ems.ems.dto.AdminDto;
import net.ems.ems.entity.Admin;
import net.ems.ems.exception.ResourceNotFoundException;
import net.ems.ems.mapper.AdminMapper;
import net.ems.ems.repository.AdminRepository;
import net.ems.ems.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        // Remove password encoding temporarily
        Admin savedAdmin = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(savedAdmin);
    }

    @Override
    public AdminDto getAdminById(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id:" + adminId));
        return AdminMapper.mapToAdminDto(admin);
    }

    @Override
    public List<AdminDto> getAllAdmin() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(AdminMapper::mapToAdminDto).collect(Collectors.toList());
    }

    @Override
    public AdminDto updateAdmin(Long adminId, AdminDto updateAdmin) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id:" + adminId));
        admin.setFirstName(updateAdmin.getFirst_name());
        admin.setLastName(updateAdmin.getLast_name());
        admin.setEmail(updateAdmin.getEmail());
        admin.setPassword(updateAdmin.getPassword()); // Set password directly
        Admin updatedAdminEntity = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(updatedAdminEntity);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with Id:" + adminId));
        adminRepository.delete(admin);
    }
}
