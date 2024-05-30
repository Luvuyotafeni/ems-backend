package net.ems.ems.mapper;

import net.ems.ems.dto.EmployeeDto;
import net.ems.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getIdNo(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getGender(),
                employee.getStatus(),
                employee.getPosition(),
                employee.getPhysicalAddress()

        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return  new Employee(
                employeeDto.getId(),
                employeeDto.getIdNo(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getGender(),
                employeeDto.getPosition(),
                employeeDto.getStatus(),
                employeeDto.getPhysicalAddress()

        );
    }
}
