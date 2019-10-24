package com.test.anhvdweb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.test.anhvdweb"})
public class AnhvdWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnhvdWebApplication.class, args);
    }

}
