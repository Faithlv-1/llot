package com.faithlv.llot.mqtt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.faithlv.llot"})
public class MqttApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqttApplication.class, args);
    }

}
