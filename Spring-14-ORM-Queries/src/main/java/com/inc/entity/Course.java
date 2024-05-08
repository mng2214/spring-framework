package com.inc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "RATING")
    private int rating;
    @Column(name = "DESCRIPTION")
    private String description;

}
