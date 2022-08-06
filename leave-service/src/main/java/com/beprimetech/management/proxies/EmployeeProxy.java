package com.beprimetech.management.proxies;


import com.beprimetech.management.models.EmployeeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "employee-service" , url = "${employee-service.url}")
    public interface EmployeeProxy {
    @GetMapping("/all")
    ResponseEntity<List<EmployeeBean>> getAllEmployees();

    @GetMapping("/find/{id}")
    EmployeeBean getEmployeeById(@PathVariable String id);
}

