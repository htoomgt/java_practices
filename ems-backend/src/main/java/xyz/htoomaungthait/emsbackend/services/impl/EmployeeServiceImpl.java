package xyz.htoomaungthait.emsbackend.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.htoomaungthait.emsbackend.dtos.EmployeeDto;
import xyz.htoomaungthait.emsbackend.entities.Employee;
import xyz.htoomaungthait.emsbackend.mappers.EmployeeMapper;
import xyz.htoomaungthait.emsbackend.repositories.EmployeeRepository;
import xyz.htoomaungthait.emsbackend.services.EmployeeService;

@Service
@AllArgsConstructor


public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = this.employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }
}
