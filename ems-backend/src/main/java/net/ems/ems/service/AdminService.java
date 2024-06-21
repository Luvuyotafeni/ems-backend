package net.ems.ems.service;

import net.ems.ems.dto.AdminDto;

import java.util.List;

public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto);
    AdminDto getAdminById(Long adminId);
    List<AdminDto> getAllAdmin();
    AdminDto updateAdmin(Long adminId, AdminDto updateAdmin);
    void deleteAdmin(Long adminId);
}
