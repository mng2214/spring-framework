package com.inc.repository;

import com.inc.entity.Department;
import com.inc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    // Display all departments in the furniture dept
    List<Department> findByDepartment(String departmentName);

    // Display all departments in the Health division
    List<Department> findByDivisionIs(String division);
    //List<Department> findByDivisionEquals(String division);

    // Display top 3 dept with division name includes "Hea" without duplicates
    List<Department> findDistinctTop3ByDivisionContainingOrderByDepartment(String division);

    @Query("select d from Department d where d.division in ?1 ")
    List<Department> getDeptDivision(List<String> divisions);

    List<Department> retrieveByDivision(String division);

    @Query(nativeQuery = true)
    List<Department> retrieveDeptByDivisionContaining(String pattern); // home %me%
}
