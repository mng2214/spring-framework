package com.icode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.icode")
@ComponentScan(basePackages = {"com.icode.proxy", "com.icode.service", "com.icode.repository"})
public class ProjectConfig {

}
