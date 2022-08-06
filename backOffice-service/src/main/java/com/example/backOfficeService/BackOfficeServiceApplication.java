package com.example.backOfficeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class BackOfficeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackOfficeServiceApplication.class, args);
    }

}
