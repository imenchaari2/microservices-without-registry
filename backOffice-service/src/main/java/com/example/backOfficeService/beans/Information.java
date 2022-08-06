package com.example.backOfficeService.beans;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;


@Data
public class Information {
    private int cin;
    private String firstName;
    private String lastName;
    private String grade;
    private String phone;
    private Address address;
    private String email;
    private String password;
    @JsonFormat(locale = "MM/DD/YYYY")
    private LocalDate recruitDay;
    private int gotLeaveDays;
    @JsonFormat(locale = "MM/DD/YYYY")
    private LocalDate archivedDay;
    private double sold;

}

