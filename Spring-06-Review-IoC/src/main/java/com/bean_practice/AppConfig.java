package com.bean_practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    FullTimeEmployee ft() {
        return new FullTimeEmployee();
    }

    @Bean
    PartTimeEmployee pt() {
        return new PartTimeEmployee();
    }


}
