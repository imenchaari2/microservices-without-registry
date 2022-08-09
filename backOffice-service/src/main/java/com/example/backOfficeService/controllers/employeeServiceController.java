package com.example.backOfficeService.controllers;

import com.example.backOfficeService.remote.employee.model.Employee;
import com.example.backOfficeService.remote.leave.model.Leave;
import com.example.backOfficeService.remote.employee.EmployeeClient;
import com.example.backOfficeService.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeeServiceController {
    private final EmployeeService employeeService;

    public employeeServiceController( EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee-service/api/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee-service/api/archived")
    public ResponseEntity<List<Employee>> getAllArchivedEmployees() {
        return employeeService.findAllArchivedEmployees();
    }

    @GetMapping("/employee-service/api/find/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/employee-service/api/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee-service/api/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee-service/api/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping("/employee-service/api/archive/{id}")
    public ResponseEntity<?> archiveEmployee(@PathVariable("id") String id) {
        return employeeService.archiveEmployee(id);
    }

    @DeleteMapping("/employee-service/api/restore/{id}")
    public ResponseEntity<?> restoreEmployee(@PathVariable("id") String id) {
        return employeeService.restoreEmployee(id);
    }


}
