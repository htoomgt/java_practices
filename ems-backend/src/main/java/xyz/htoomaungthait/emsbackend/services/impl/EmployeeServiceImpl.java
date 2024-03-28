package xyz.htoomaungthait.emsbackend.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.htoomaungthait.emsbackend.dtos.EmployeeDto;
import xyz.htoomaungthait.emsbackend.entities.Employee;
import xyz.htoomaungthait.emsbackend.exceptions.ResourceNotFoundException;
import xyz.htoomaungthait.emsbackend.mappers.EmployeeMapper;
import xyz.htoomaungthait.emsbackend.repositories.EmployeeRepository;
import xyz.htoomaungthait.emsbackend.services.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Optional<Employee> employeeById = Optional.of(this.employeeRepository.getReferenceById(employeeId));

        return EmployeeMapper.mapToEmployeeDto(employeeById.orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id :" + employeeId) ));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee>  employees = this.employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto updatedEmployee) {
        Optional<Employee> employee = Optional.of(employeeRepository.findById(employeeId)).orElseThrow( () -> new ResourceNotFoundException("Employee doesn't exists with given id"));

        if(employee.isPresent()){
            employee.get().setFirstName(updatedEmployee.getFirstName());
            employee.get().setLastName(updatedEmployee.getLastName());
            employee.get().setEmail(updatedEmployee.getEmail());
            employeeRepository.save(employee.get());
            return EmployeeMapper.mapToEmployeeDto(employee.get());
        }



       return null;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow( () -> new ResourceNotFoundException("Employee doesn't exists with given id"));

        employeeRepository.deleteById(employee.getId());

    }

}
