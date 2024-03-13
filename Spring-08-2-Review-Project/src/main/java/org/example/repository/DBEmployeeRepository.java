package org.example.repository;

import org.example.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class DBEmployeeRepository implements EmployeeRepository {
    @Override
    public int getHourlyRate() {
        Employee employee1 = new Employee("Joe", "Dev", 80);
        return employee1.getHourlyRate();
    }

}
