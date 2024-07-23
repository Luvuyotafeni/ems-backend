package net.ems.ems.mapper;

import net.ems.ems.dto.AdminDto;
import net.ems.ems.entity.Admin;

public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin) {
        return new AdminDto(
                admin.getId(),
                admin.getFirstName(),
                admin.getLastName(),
                admin.getEmail(),
                null // Do not expose password
        );
    }

    public static Admin mapToAdmin(AdminDto adminDto) {
        return new Admin(
                adminDto.getId(),
                adminDto.getFirst_name(),
                adminDto.getLast_name(),
                adminDto.getEmail(),
                adminDto.getPassword() // Only for creating/updating
        );
    }
}
