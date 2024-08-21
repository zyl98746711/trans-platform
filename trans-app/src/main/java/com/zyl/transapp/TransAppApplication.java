package com.zyl.transapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zyl.*"})
@EnableJpaRepositories(basePackages = "com.zyl.repository")
@EntityScan(basePackages = "com.zyl.entity")
public class TransAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransAppApplication.class, args);
    }

}
