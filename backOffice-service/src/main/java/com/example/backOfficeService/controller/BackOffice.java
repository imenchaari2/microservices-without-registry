package com.example.backOfficeService.controller;

import com.example.backOfficeService.beans.Employee;
import com.example.backOfficeService.beans.Leave;
import com.example.backOfficeService.proxies.EmployeeProxy;
import com.example.backOfficeService.proxies.LeaveProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BackOffice {
    private final LeaveProxy leaveProxy;
    private final EmployeeProxy employeeProxy;

    public BackOffice(LeaveProxy leaveProxy, EmployeeProxy employeeProxy) {
        this.leaveProxy = leaveProxy;
        this.employeeProxy = employeeProxy;
    }

    @GetMapping("/employee-service/api/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return employeeProxy.getAllEmployees();
    }

    @GetMapping("/employee-service/api/archived")
    public ResponseEntity<List<Employee>> getAllArchivedEmployees() {
        return employeeProxy.getAllArchivedEmployees();
    }

    @GetMapping("/employee-service/api/find/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeProxy.getEmployeeById(id);
    }

    @PostMapping("/employee-service/api/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeProxy.addEmployee(employee);
    }

    @PutMapping("/employee-service/api/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return employeeProxy.updateEmployee(employee);
    }

    @DeleteMapping("/employee-service/api/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        return employeeProxy.deleteEmployee(id);
    }

    @DeleteMapping("/employee-service/api/archive/{id}")
    public ResponseEntity<?> archiveEmployee(@PathVariable("id") String id) {
        return employeeProxy.archiveEmployee(id);
    }

    @DeleteMapping("/employee-service/api/restore/{id}")
    public ResponseEntity<?> restoreEmployee(@PathVariable("id") String id) {
        return employeeProxy.restoreEmployee(id);
    }

    // leave service apis

    @GetMapping(value = "/leave-service/api/find/{leaveId}")
    public Leave getLeaveById(@PathVariable String leaveId) {
        return leaveProxy.getLeaveById(leaveId);
    }

    @PostMapping("/leave-service/api/{employeeId}/addLeave")
    public ResponseEntity<Leave> addLeave(@RequestBody Leave leave, @PathVariable String employeeId) {
        return leaveProxy.addLeave(leave, employeeId);
    }

    @GetMapping(value = "/leave-service/api/{employeeId}/Leaves")
    public ResponseEntity<List<Leave>> getAllLeavesByEmployee(@PathVariable String employeeId) {
        return leaveProxy.getAllLeavesByEmployee(employeeId);
    }

    @DeleteMapping(value = "/leave-service/api/deleteLeave/{leaveId}")
    public ResponseEntity<?> deleteLeave(@PathVariable("leaveId") String leaveId) {
        return leaveProxy.deleteLeave(leaveId);
    }

    @PutMapping("/leave-service/api/updateLeave")
    public ResponseEntity<Leave> updateLeave(@RequestBody Leave leave) {
        return leaveProxy.updateLeave(leave);
    }

}
