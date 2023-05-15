package com.invext.cardsupportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CardSupportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardSupportServiceApplication.class, args);
    }

}
