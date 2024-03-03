package com.org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DealerApp {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigCar.class);

        Car c = context.getBean(Car.class);
        Person person = context.getBean(Person.class);

        System.out.println("Person : " + person.getName());
        System.out.println("Car's make : " + c.getMake());
        System.out.println("Person's car : " + person.getCar().getMake());

    }
}
