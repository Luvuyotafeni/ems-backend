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
    private String IdNo;
    private String FirstName;
    private String LastName;
    private String email;
    private String Gender;
    private String position;
    private String status;
    private String PhysicalAddress;
    
}
