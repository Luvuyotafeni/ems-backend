package net.ems.ems.mapper;

import net.ems.ems.dto.AdminDto;
import net.ems.ems.entity.Admin;

public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin){
        return new AdminDto(
                admin.getId(),
                admin.getFirstName(),
                admin.getLastName(),
                admin.getEmail(),
                admin.getPassword()
        );
    }

    public static Admin mapToAdmin(AdminDto adminDto){
        return new Admin(
                adminDto.getId(),
                adminDto.getAdmin_Name(),
                adminDto.getAdmin_LastName(),
                adminDto.getAdmin_Email(),
                adminDto.getAdmin_Password()
        );
    }
}
