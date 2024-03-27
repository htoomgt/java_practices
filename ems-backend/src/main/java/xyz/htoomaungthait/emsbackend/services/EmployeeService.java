package xyz.htoomaungthait.emsbackend.services;

import xyz.htoomaungthait.emsbackend.dtos.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);


}
