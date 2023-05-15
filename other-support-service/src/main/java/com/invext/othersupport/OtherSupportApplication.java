package com.invext.othersupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OtherSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtherSupportApplication.class, args);
    }

}
