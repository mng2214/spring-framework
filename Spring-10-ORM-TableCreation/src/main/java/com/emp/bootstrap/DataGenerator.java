package com.emp.bootstrap;

import com.emp.entity.Car;
import com.emp.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) {

        Car c1 = new Car("BMW","M5");
        Car c2 = new Car("Audi","S6");
        Car c3 = new Car("Honda","Civic");

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

    }
}
