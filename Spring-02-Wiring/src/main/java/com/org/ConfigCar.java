package com.org;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {
    @Bean
    Car car() {
        Car car = new Car();
        car.setMake("BMW");
        return car;
    }
// Wiring - Direct Wiring
//    @Bean
//    Person person() {
//        Person person = new Person();
//        person.setName("Artur");
//        person.setCar(car());
//        return person;
//    }

    //Auto Wiring
    @Bean
    Person person(Car car) {
        Person person = new Person();
        person.setName("Artur");
        person.setCar(car);
        return person;
    }

}
