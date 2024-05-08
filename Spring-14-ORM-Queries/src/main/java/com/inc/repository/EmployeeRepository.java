package com.inc.repository;

import com.inc.entity.Employee;
import jakarta.transaction.Transactional;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    Optional<Employee> getEmployeeByEmail(String email); // positional parameters

    @Query("Select e from Employee e Where e.email=?1 and e.salary>?2")
    Optional<Employee> getEmployeeByEmail(String email, int salary);  // positional parameters

    // Not Equal
    @Query("select e from Employee e where e.salary <> ?1")
    // not equal
    List<Employee> getEmpSalaryNotEqual(int salary);

    // like / contains / startswith / endswith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmpFirstNameLike(String name);

    // less then
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThen(int salary);

    // greater then
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThen(int salary);

    // before date
    @Query("select e from Employee e where e.hireDate < ?1")
    List<Employee> getEmpHiredDateBefore(LocalDate date);

    // between
    // @Query("select e from Employee e where e.salary > ?1 and e.salary< ?2")
    @Query("select e from Employee e where e.salary between ?1 And ?2")
    List<Employee> getEmpSalaryBetween(int salary1, int salary2);

    // null
    @Query("Select e from  Employee e where e.email is null")
    List<Employee> getEmpEmailIsNull();

    // Sorting ASC
    @Query("Select e from  Employee e order by e.salary ASC ")
    List<Employee> getEmpSalaryOrderAsc();

    // Sorting DSC
    @Query("Select e from  Employee e order by e.salary DESC ")
    List<Employee> getEmpSalaryOrderDsc();

    // read
    @Query(value = "select * from employees where salary ?1", nativeQuery = true)// native sql
    List<Employee> readEmpDetailBySalary(int salary);

    @Query("Select e from  Employee e where e.salary = :salary ")// positional param
    List<Employee> getEmpSalary(@Param("salary") int salary);

    @Modifying
    @Transactional
    @Query("update Employee e set e.email = 'updated@email.com' where e.id = :id")  // UPDATE QUERY
    void updateEmpJPQA(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update employees set email 'updated@email.com' where id = :id", nativeQuery = true)  // UPDATE QUERY
    void updateEmpSQL(@Param("id") int id);






}
