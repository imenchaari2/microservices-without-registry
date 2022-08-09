package com.example.backOfficeService.remote.employee;


import com.example.backOfficeService.remote.employee.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "employee-service" , url = "${services.extern.employee-service.url}")
    public interface EmployeeClient {
    @GetMapping("/all")
    ResponseEntity<List<Employee>> getAllEmployees();
    @GetMapping("/archived")
    ResponseEntity<List<Employee>> getAllArchivedEmployees();
    @GetMapping("/find/{id}")
    Employee getEmployeeById(@PathVariable("id") String id);
    @PostMapping("/add")
    ResponseEntity<Employee> addEmployee(@RequestBody Employee employee);
    @PutMapping("/update")
    ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee);
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteEmployee(@PathVariable("id") String id);
    @DeleteMapping("/archive/{id}")
    ResponseEntity<?> archiveEmployee(@PathVariable("id") String id);
    @DeleteMapping("/restore/{id}")
    ResponseEntity<?> restoreEmployee(@PathVariable("id") String id);

}

