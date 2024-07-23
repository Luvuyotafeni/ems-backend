package net.ems.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private Long Id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
}

