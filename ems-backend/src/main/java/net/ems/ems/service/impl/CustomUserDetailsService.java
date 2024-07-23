package net.ems.ems.service.impl;
/*
import lombok.AllArgsConstructor;
import net.ems.ems.entity.Admin;
import net.ems.ems.exception.ResourceNotFoundException;
import net.ems.ems.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("Admin not found with email:"+email));
        return User.builder()
                .username(admin.getEmail())
                .password(admin.getPassword())
                .roles("ADMIN")
                .build();

    }
}
*/