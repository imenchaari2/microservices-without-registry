package com.example.backOfficeService.remote.leave;


import com.example.backOfficeService.remote.leave.model.Leave;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "leave-service" , url = "${services.extern.leave-service.url}")
    public interface LeaveClient {
    @GetMapping(value = "/find/{leaveId}")
    Leave getLeaveById(@PathVariable String leaveId);
    @PostMapping("/{employeeId}/addLeave")
    ResponseEntity<Leave> addLeave(@RequestBody Leave leave, @PathVariable String employeeId);
    @GetMapping(value = "/{employeeId}/Leaves")
    ResponseEntity<List<Leave>> getAllLeavesByEmployee(@PathVariable String employeeId);
    @DeleteMapping(value = "/deleteLeave/{leaveId}")
    ResponseEntity<?> deleteLeave(@PathVariable("leaveId") String leaveId);
    @PutMapping("/updateLeave")
    ResponseEntity<Leave> updateLeave(@RequestBody Leave leave);
}

