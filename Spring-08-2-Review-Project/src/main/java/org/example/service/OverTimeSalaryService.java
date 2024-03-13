package org.example.service;

import org.example.repository.EmployeeRepository;
import org.example.repository.HoursRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OverTimeSalaryService {
    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository;

    public OverTimeSalaryService(EmployeeRepository employeeRepository, @Qualifier("OVERTIME") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateOverTImeSalary() {
        System.out.println(employeeRepository.getHourlyRate() * hoursRepository.getHours());
    }
}
