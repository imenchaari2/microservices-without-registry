package com.beprimetech.management.repository;

import com.beprimetech.management.models.Leave;
import com.beprimetech.management.models.LeaveState;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveRepository extends MongoRepository<Leave, String> {
    Optional<Leave> findLeaveByLeaveId(String id);
    Sort findLeaveByLeaveStateLeave(LeaveState leaveState);

}
