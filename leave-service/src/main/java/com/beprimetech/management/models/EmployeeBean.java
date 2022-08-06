package com.beprimetech.management.models;

import lombok.Data;
import org.assertj.core.util.Lists;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class EmployeeBean {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String grade;
    private int gotLeaveDays;
    private double sold;
    private Boolean isArchived;
//    private List<Leave> leavesList = Lists.newArrayList();

}
