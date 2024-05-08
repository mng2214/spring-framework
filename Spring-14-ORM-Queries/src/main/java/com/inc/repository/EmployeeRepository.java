package com.inc.repository;

import com.inc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Display all employees with email address ''
    List<Employee> findByEmail(String email);

    //Display all employees with first name ' ' and last name ' ' , also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ' '
    List<Employee> findByFirstNameNot(String firstName);

    //Display all employees where last name starts with ' '
    List<Employee> findByLastNameStartingWith(String lastName);

    //Display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(int salary);

    //Display all employees with salaries less than ' '
    List<Employee> findBySalaryLessThan(int salary);

    //Display all employees that has been hired between '' and  ''
    List<Employee> findByHireDateBetween(LocalDate start, LocalDate end);

    //Display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanOrderBySalaryDesc(int salary);

    //Display top unique 3 employees that is making less than ''
    List<Employee> findDistinctTop3BySalaryLessThanOrderBySalaryDesc(int salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    @Query("Select e from Employee e Where e.email='jhelsdonqo@oaic.gov.au'")
    Employee getEmployeeByEmail();

    @Query("Select e.salary from Employee e Where e.email='jhelsdonqo@oaic.gov.au'")
    Integer getEmployeeSalary();

    @Query("Select e from Employee e Where e.email=?1")
    Optional<Employee> getEmployeeByEmail(String email);


}
