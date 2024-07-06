package net.ems.ems.controller;


import lombok.AllArgsConstructor;
import net.ems.ems.dto.AdminDto;
import net.ems.ems.service.AdminService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admins")
@AllArgsConstructor

public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto){
        AdminDto createdAdmin = adminService.createAdmin(adminDto);
        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long adminId) {
        AdminDto adminDto = adminService.getAdminById(adminId);
        return ResponseEntity.ok(adminDto);
    }

    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins(){
        List<AdminDto> admins = adminService.getAllAdmin();
        return ResponseEntity.ok(admins);
    }

    @PutMapping("{id}")
}
