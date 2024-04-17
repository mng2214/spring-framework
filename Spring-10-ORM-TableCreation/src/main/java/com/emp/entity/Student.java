package com.emp.entity;

import com.emp.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "studentFirstName", length = 100)
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    private String email;

    @Transient // do not populate in the table
    private String city;
    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateAndTime;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
