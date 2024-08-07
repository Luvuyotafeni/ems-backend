package net.ems.ems.controller;

import lombok.AllArgsConstructor;
import net.ems.ems.dto.AdminDto;
import net.ems.ems.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
        AdminDto createdAdmin = adminService.createAdmin(adminDto);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long adminId) {
        AdminDto adminDto = adminService.getAdminById(adminId);
        return ResponseEntity.ok(adminDto);
    }

    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins() {
        List<AdminDto> admins = adminService.getAllAdmin();
        return ResponseEntity.ok(admins);
    }

    @PutMapping("{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable("id") Long adminId,
                                                @RequestBody AdminDto adminDto) {
        AdminDto updatedAdmin = adminService.updateAdmin(adminId, adminDto);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long adminId) {
        adminService.deleteAdmin(adminId);
        return ResponseEntity.ok("Admin successfully deleted");
    }
}
