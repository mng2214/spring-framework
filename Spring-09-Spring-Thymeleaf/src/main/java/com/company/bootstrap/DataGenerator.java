package com.company.bootstrap;

import com.company.model.Student;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DataGenerator {
    public static Faker faker = new Faker(Locale.US);
    public static List<Student> createStudent() {
        return Arrays.asList(
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().stateAbbr()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().stateAbbr()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().stateAbbr()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().stateAbbr()),
                new Student(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(20, 50), faker.address().stateAbbr()));
    }

}
