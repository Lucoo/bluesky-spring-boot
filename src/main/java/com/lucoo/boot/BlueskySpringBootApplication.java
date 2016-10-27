package com.lucoo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
public class BlueskySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlueskySpringBootApplication.class, args);
    }
}
