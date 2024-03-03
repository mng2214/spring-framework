package com.icode.stereotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = "com.icode.stereotype_annotation")
public class ConfigCourse {

}
