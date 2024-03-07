package com.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherAppConfig {

    @Bean(name = "welcome")
    String welcome() {
        return "Welcome to Spring";
    }

    @Bean(name = "practice")
    String practice() {
        return "Spring Core Practice";
    }
}
