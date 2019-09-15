package com.ntuc.income;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ShipmentServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(ShipmentServiceApp.class);
    }
}
