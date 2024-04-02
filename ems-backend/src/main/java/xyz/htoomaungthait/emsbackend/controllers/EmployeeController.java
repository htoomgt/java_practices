package xyz.htoomaungthait.emsbackend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.htoomaungthait.emsbackend.dtos.ApiResponse;
import xyz.htoomaungthait.emsbackend.dtos.EmployeeDto;
import xyz.htoomaungthait.emsbackend.services.EmployeeService;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<ApiResponse> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = null;
        try{
            savedEmployee = employeeService.createEmployee(employeeDto);
        } catch(Exception ex){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("error", "cannot create employee this time! Detail => " + ex.getMessage().substring(0,100), null));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("success", "new employee has been created!", savedEmployee));
    }

    // Build Get Employee REST  API
    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeDto searchedEmployee;
        try {
            searchedEmployee = employeeService.getEmployeeById(employeeId);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("error", "Cannot search this time ! Detail => " + ex.getMessage(), null));
        }

        return ResponseEntity.ok(new ApiResponse("success", "successfully searched employee", searchedEmployee));
    }

    // Build Get All Employee
    @GetMapping
    public ResponseEntity<ApiResponse> getAllEmployees(){
        List<EmployeeDto> employees = null;
        try{
            employees = employeeService.getAllEmployee();
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("error", "all employees cannot be listed! Detail => " + ex.getMessage(), null));
        }

        return ResponseEntity.ok(new ApiResponse("success", "can list all employee", employees));
    }

    @PutMapping("{id}")
    public ResponseEntity<ApiResponse> updateEmployeeById(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto employeeDto){
        EmployeeDto updatedEmployee = null;
        try{
            updatedEmployee = employeeService.updateEmployeeById(employeeId, employeeDto);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("error", "cannot update this time ! Detail => " + ex.getMessage(), null));
        }


        return ResponseEntity.ok(new ApiResponse("success", "provided employee's data has been updated", updatedEmployee));
    }

    // Delete Employee by id
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteEmployeeById(@PathVariable("id") Long employeeId){
        try {
            employeeService.deleteEmployee(employeeId);

        }catch(Exception ex){
            return  ResponseEntity.status(422).body(new ApiResponse("error", "cannot delete employee this time. Detail => " + ex.getMessage(), null));
        }

        return ResponseEntity.ok(new ApiResponse("success", "successfully deleted the employee with id: " + employeeId.toString(), null));

    }

}
