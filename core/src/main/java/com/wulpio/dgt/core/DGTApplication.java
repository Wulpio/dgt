package com.wulpio.dgt.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.wulpio.dgt"})
public class DGTApplication {

    public static void main(String[] args) {
        SpringApplication.run(DGTApplication.class, args);
    }

}
