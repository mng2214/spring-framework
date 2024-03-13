package org.example.service;

import lombok.AllArgsConstructor;
import org.example.repository.DBEmployeeRepository;
import org.example.repository.EmployeeRepository;
import org.example.repository.HoursRepository;
import org.example.repository.RegularHours;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@AllArgsConstructor
@Component
public class SalaryService {

    private final EmployeeRepository employeeRepository;
    private final HoursRepository hoursRepository;

    public SalaryService(EmployeeRepository employeeRepository, @Qualifier("REGULAR") HoursRepository hoursRepository) {
        this.employeeRepository = employeeRepository;
        this.hoursRepository = hoursRepository;
    }

    public void calculateRegularlySalary() {
        int salary = employeeRepository.getHourlyRate() * hoursRepository.getHours();
        System.out.println(salary);
    }

}
