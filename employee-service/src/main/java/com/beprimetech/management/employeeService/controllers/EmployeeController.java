package com.beprimetech.management.employeeService.controllers;

import com.beprimetech.management.employeeService.models.Employee;
import com.beprimetech.management.employeeService.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee-service/api")
public class EmployeeController {

    private final EmployeeService empService;
    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = empService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/archived")
    public ResponseEntity<List<Employee>> getAllArchivedEmployees() {
        List<Employee> employees = empService.findAllArchivedEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return empService.findEmployeeById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = empService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = empService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        empService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/archive/{id}")
    public ResponseEntity<?> archiveEmployee(@PathVariable("id") String id) {
        empService.archiveEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/restore/{id}")
    public ResponseEntity<?> restoreEmployee(@PathVariable("id") String id) {
        empService.restoreEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
