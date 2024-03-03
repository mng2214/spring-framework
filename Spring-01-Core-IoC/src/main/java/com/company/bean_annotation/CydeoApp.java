package com.company.bean_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(ConfigApp.class, ConfigAny.class);

        FullTimeMentor ft = container.getBean(FullTimeMentor.class);
        ft.createAccount();

        PartTimeMentor pt1 = container.getBean(PartTimeMentor.class);
        pt1.createAccount();

        PartTimeMentor pt2 = container.getBean("p2",PartTimeMentor.class);
        pt2.createAccount();

        ConfigAny any = container.getBean(ConfigAny.class);
        System.out.println(any.str());

        String str = container.getBean(String.class);
        System.out.println(str);

    }
}
