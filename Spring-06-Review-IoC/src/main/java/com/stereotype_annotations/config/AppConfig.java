package com.stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.stereotype_annotations.model")
public class AppConfig {
}
