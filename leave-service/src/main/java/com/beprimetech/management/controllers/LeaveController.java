package com.beprimetech.management.controllers;

import com.beprimetech.management.models.EmployeeBean;
import com.beprimetech.management.models.Leave;
import com.beprimetech.management.proxies.EmployeeProxy;
import com.beprimetech.management.services.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/leave-service/api/")
public class LeaveController {

    LeaveService leaveService;
    EmployeeProxy employeeProxy;

//    @GetMapping(value = "/allEmployees")
//    public ResponseEntity<List<EmployeeBean>> getEmployees() {
//        return employeeProxy.getAllEmployees();
//    }
//    @GetMapping(value = "/all")
//    public List<Leave> getLeaves() {
//        return leaveService.getAllLeaves();
//    }
    @GetMapping(value = "/find/{leaveId}")
    public Leave getLeaveById(@PathVariable String leaveId) {
        return leaveService.findLeaveById(leaveId);
    }

    @PostMapping("/{employeeId}/addLeave")
    public ResponseEntity<Leave> addLeave(@RequestBody Leave leave, @PathVariable String employeeId) {
        Leave newLeave = leaveService.addLeave(leave,employeeId);
        return new ResponseEntity<>(newLeave, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{employeeId}/Leaves")
    public ResponseEntity<List<Leave>> getAllLeavesByEmployee(@PathVariable String employeeId) {
        List<Leave> leaves = leaveService.getAllLeavesByEmployee(employeeId);
        return new ResponseEntity<>(leaves, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteLeave/{leaveId}")
    public ResponseEntity<?> deleteLeave(@PathVariable("leaveId") String leaveId) {
        leaveService.deleteLeave(leaveId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//    @PutMapping("/updateLeave")
//    public ResponseEntity<Leave> updateLeave(@RequestBody Leave leave) {
//        Leave updatedLeave = leaveService.updateLeave(leave);
//        return new ResponseEntity<>(updatedLeave, HttpStatus.OK);
//    }


}
