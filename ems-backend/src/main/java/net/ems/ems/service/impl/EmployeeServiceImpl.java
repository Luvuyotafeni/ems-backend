package net.ems.ems.service.impl;

import lombok.AllArgsConstructor;
import net.ems.ems.dto.EmployeeDto;
import net.ems.ems.entity.Employee;
import net.ems.ems.exception.ResourceNotFoundException;
import net.ems.ems.mapper.EmployeeMapper;
import net.ems.ems.repository.EmployeeRepository;
import net.ems.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is does not exist with given ID:" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with gievn Id"+ employeeId)
        );
       employee.setIdNo(updatedEmployee.getIdNo());
       employee.setFirstName(updatedEmployee.getFirstName());
       employee.setLastName(updatedEmployee.getLastName());
       employee.setEmail(updatedEmployee.getEmail());
       employee.setGender(updatedEmployee.getGender());
       employee.setStatus((updatedEmployee.getStatus()));
       employee.setPosition(updatedEmployee.getPosition());
       employee.setPhysicalAddress(updatedEmployee.getPhysicalAddress());

       Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with gievn Id"+ employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
