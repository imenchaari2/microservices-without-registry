package com.example.backOfficeService.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Employee {
    @Id
    private String id;
    private Information information;
    private Boolean isArchived;
}
