package com.beprimetech.management.services;


import com.beprimetech.management.models.EmployeeBean;
import com.beprimetech.management.models.Leave;
import com.beprimetech.management.models.LeaveState;
import com.beprimetech.management.proxies.EmployeeProxy;
import com.beprimetech.management.repository.LeaveRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class LeaveService {



    private final MongoTemplate mongoTemplate;
    private final LeaveRepository leaveRepository;

    private final EmployeeProxy employeeProxy;

    public LeaveService(MongoTemplate mongoTemplate, LeaveRepository leaveRepository, EmployeeProxy employeeProxy) {
        this.mongoTemplate = mongoTemplate;
        this.leaveRepository = leaveRepository;
        this.employeeProxy = employeeProxy;
    }

    public Leave findLeaveById(String id) {
        return leaveRepository.findLeaveByLeaveId(id).orElseThrow(
                () -> new LeaveNotFoundException("leave by id" + id + "not found"));
    }

    public Leave addLeave(Leave leave,String employeeId) {
        EmployeeBean employeeBean = employeeProxy.getEmployeeById(employeeId);
        leave.setEmployeeId(employeeId);
        leave.setEmployeeBean(employeeBean);
        leave.setLeaveStateLeave(LeaveState.EN_ATTENTE);
        return leaveRepository.save(leave);
    }

    public List<Leave> getAllLeavesByEmployee(String employeeId) {
        List<Leave> leavesByEmployee = Lists.newArrayList();
        List<Leave> leaves = leaveRepository.findAll();
        var leaveList = leaves.stream().filter(leave -> leave.getEmployeeId().equals(employeeId)).collect(Collectors.toList());
        leavesByEmployee.addAll(leaveList);
        return leavesByEmployee;
    }
    public Leave updateLeave (Leave leave) {
        Query query = new Query();
        query.addCriteria(Criteria.where("leaveId").is(leave.getLeaveId()));
        Update update = new Update();
        mongoTemplate.updateFirst(query, update, Leave.class);
        leave = findLeaveById(leave.getLeaveId());
        return leave;
    }


    public void deleteLeave(String id) {
       Leave leave = this.findLeaveById(id);
        leaveRepository.delete(leave);
    }


    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }
}
