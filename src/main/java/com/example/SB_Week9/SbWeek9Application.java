package com.example.SB_Week9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SbWeek9Application {

    public static void main(String[] args) {
        SpringApplication.run(SbWeek9Application.class, args);
    }

}
