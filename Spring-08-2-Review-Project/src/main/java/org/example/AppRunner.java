package org.example;

import org.example.config.EmployeeConfig;
import org.example.service.OverTimeSalaryService;
import org.example.service.SalaryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(EmployeeConfig.class);

        SalaryService salaryService = container.getBean(SalaryService.class);
        salaryService.calculateRegularlySalary();

        OverTimeSalaryService overTimeSalaryService = container.getBean(OverTimeSalaryService.class);
        overTimeSalaryService.calculateOverTImeSalary();


    }
}
