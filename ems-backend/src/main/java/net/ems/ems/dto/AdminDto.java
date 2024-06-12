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
    private String Admin_Name;
    private String Admin_LastName;
    private String Admin_Email;
    private String Admin_Password;
}

