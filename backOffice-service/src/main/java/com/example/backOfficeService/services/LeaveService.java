package com.example.backOfficeService.services;

import com.example.backOfficeService.remote.leave.LeaveClient;
import com.example.backOfficeService.remote.leave.model.Leave;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LeaveService {
    private final LeaveClient leaveClient;

    public LeaveService(LeaveClient leaveClient) {
        this.leaveClient = leaveClient;
    }

    public Leave findLeaveById(String id) {
        return leaveClient.getLeaveById(id);
    }

    public ResponseEntity<Leave> addLeave(Leave leave, String employeeId) {
        return leaveClient.addLeave(leave, employeeId);
    }

    public ResponseEntity<List<Leave>> getAllLeavesByEmployee(String employeeId) {
        return leaveClient.getAllLeavesByEmployee(employeeId);
    }

    public ResponseEntity<Leave> updateLeave(Leave leave) {
        return leaveClient.updateLeave(leave);
    }

    public ResponseEntity<?> deleteLeave(String leaveId) {
        return leaveClient.deleteLeave(leaveId);
    }
}
