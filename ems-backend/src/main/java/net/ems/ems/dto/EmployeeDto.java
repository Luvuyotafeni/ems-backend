package net.ems.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {
    private Long id;
    private String first_name;
    private String Last_name;
    private String Gender;
    private String email;
    private String Physical_Address;
    private String IdNo;
    private String status;
    private String position;
    
}