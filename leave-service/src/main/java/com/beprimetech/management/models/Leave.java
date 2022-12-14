package com.beprimetech.management.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "LeaveDb")
@Builder(toBuilder = true)
public class Leave {
    @Id
    private String leaveId;
    private String employeeId;
    @Transient
    private EmployeeBean employeeBean;
    @JsonFormat(locale = "MM/DD/YYYY")
    private LocalDate creationDate;
    @JsonFormat(locale = "MM/DD/YYYY")
    private LocalDate departureDate;
    @JsonFormat(locale = "MM/DD/YYYY")
    private LocalDate returnDate;
    @Transient
    private long nbDaysLeave = 0;
    private String reasonLeave;
    private String leaveReasonArea;
    private LeaveState leaveStateLeave;


    public Update updateLeave(Leave leave) {
        if (Objects.isNull(leave)) {
            return null;
        }
        Update update = new Update();
        update.set("nbDaysLeave",leave.getNbDaysLeave());
        update.set("reasonLeave",leave.getReasonLeave());
        update.set("departureDate",leave.getDepartureDate());
        update.set("returnDate",leave.getReturnDate());
        update.set("leaveReasonArea",leave.getLeaveReasonArea());
        update.set("leaveStateLeave",leave.getLeaveStateLeave());
        return update;
    }


}
