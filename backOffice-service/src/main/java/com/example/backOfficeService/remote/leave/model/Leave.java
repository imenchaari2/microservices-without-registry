package com.example.backOfficeService.remote.leave.model;


import com.example.backOfficeService.remote.employee.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;

@Data
public class Leave {
    @Id
    private String leaveId;
    private String employeeId;
    @Transient
    private Employee employeeBean;
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

}
