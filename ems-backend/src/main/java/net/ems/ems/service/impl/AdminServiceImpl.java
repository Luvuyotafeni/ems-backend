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
import java.util.stream.Collectors;

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
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(AdminMapper::mapToAdminDto).collect(Collectors.toList());
    }

    @Override
    public AdminDto updateAdmin(Long adminId, AdminDto updateAdmin) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id:"+adminId));
        admin.setFirstName(updateAdmin.getAdmin_Name());
        admin.setLastName(updateAdmin.getAdmin_LastName());
        admin.setEmail(updateAdmin.getAdmin_Email());
        admin.setPassword(passwordEncoder.encode(updateAdmin.getAdmin_Password()));
        Admin updateAdminEntity = adminRepository.save(admin);
        return AdminMapper.mapToAdminDto(updateAdminEntity);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with Id:"+adminId));
        adminRepository.delete(admin);
    }

}
