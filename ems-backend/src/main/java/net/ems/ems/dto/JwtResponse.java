package net.ems.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class JwtResponse {
    private String token;
    private String email;
}
