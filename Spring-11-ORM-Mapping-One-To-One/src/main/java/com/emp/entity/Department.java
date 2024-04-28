package com.emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departments")
public class Department  extends  BaseEntity{

    private String department;
    private String division;

    public Department(String department, String division) {
        this.department = department;
        this.division = division;
    }
}
