package com.utxj.apicontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.utxj.apicontrol.repository")
public class ApicontrolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApicontrolApplication.class, args);
    }
}
