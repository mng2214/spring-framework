package com.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRun {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, AnotherAppConfig.class);

        FullTimeEmployee ft = context.getBean(FullTimeEmployee.class);
        ft.createAccount();

        System.out.println("-".repeat(40));

        PartTimeEmployee pt = context.getBean(PartTimeEmployee.class);
        pt.createAccount();

        System.out.println("-".repeat(40));

        Object welcome = context.getBean("welcome");
        System.out.println(welcome);

        System.out.println("-".repeat(40));

        Object practice = context.getBean("practice",String.class);
        System.out.println(practice);


    }


}
