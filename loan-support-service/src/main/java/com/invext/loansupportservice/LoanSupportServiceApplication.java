package com.invext.loansupportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoanSupportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanSupportServiceApplication.class, args);
    }
}
