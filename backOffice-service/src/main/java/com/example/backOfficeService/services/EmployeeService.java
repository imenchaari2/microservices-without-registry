package com.example.backOfficeService.services;

import com.example.backOfficeService.remote.employee.EmployeeClient;
import com.example.backOfficeService.remote.employee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeClient employeeClient;

    public EmployeeService(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        return employeeClient.addEmployee(employee);
    }

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }

    public ResponseEntity<List<Employee>> findAllArchivedEmployees() {
        return employeeClient.getAllArchivedEmployees();
    }

    public ResponseEntity<Employee> updateEmployee(Employee employee) {
        return employeeClient.updateEmployee(employee);
    }

    public Employee findEmployeeById(String id) {
        return employeeClient.getEmployeeById(id);
    }

    public ResponseEntity<?> deleteEmployee(String id) {
        return employeeClient.deleteEmployee(id);
    }

    public ResponseEntity<?> archiveEmployee(String id) {
        return employeeClient.archiveEmployee(id);
    }

    public ResponseEntity<?> restoreEmployee(String id) {
        return employeeClient.restoreEmployee(id);
    }
}
