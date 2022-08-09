package com.example.backOfficeService.controllers;

import com.example.backOfficeService.remote.leave.model.Leave;
import com.example.backOfficeService.services.LeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class leaveServiceController {
private final LeaveService leaveService;

    public leaveServiceController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping(value = "/leave-service/api/find/{leaveId}")
    public Leave getLeaveById(@PathVariable String leaveId) {
        return leaveService.findLeaveById(leaveId);
    }

    @PostMapping("/leave-service/api/{employeeId}/addLeave")
    public ResponseEntity<Leave> addLeave(@RequestBody Leave leave, @PathVariable String employeeId) {
        return leaveService.addLeave(leave, employeeId);
    }

    @GetMapping(value = "/leave-service/api/{employeeId}/Leaves")
    public ResponseEntity<List<Leave>> getAllLeavesByEmployee(@PathVariable String employeeId) {
        return leaveService.getAllLeavesByEmployee(employeeId);
    }

    @DeleteMapping(value = "/leave-service/api/deleteLeave/{leaveId}")
    public ResponseEntity<?> deleteLeave(@PathVariable("leaveId") String leaveId) {
        return leaveService.deleteLeave(leaveId);
    }

    @PutMapping("/leave-service/api/updateLeave")
    public ResponseEntity<Leave> updateLeave(@RequestBody Leave leave) {
        return leaveService.updateLeave(leave);
    }

}
