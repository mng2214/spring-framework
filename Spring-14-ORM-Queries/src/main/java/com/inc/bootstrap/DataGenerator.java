package com.inc.bootstrap;

import com.inc.repository.DepartmentRepository;
import com.inc.repository.EmployeeRepository;
import com.inc.repository.RegionRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------------------Region Start-------------------------");

        System.out.println("findByCountry" + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry" + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContainingIgnoreCase" + regionRepository.findByCountryContainingIgnoreCase("United"));
        System.out.println("findByCountryContainingOrderByCountry" + regionRepository.findByCountryContainingOrderByCountry("Asia"));
        System.out.println("findTop2ByCountry" + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("-------------------------Region End-------------------------");
        System.out.println("-------------------------Department Start-------------------------");

        System.out.println("findByDepartment" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivisionIs" + departmentRepository.findByDivisionIs("Health"));
        System.out.println("findDistinctTop3ByDivisionContainingOrderByDepartment" + departmentRepository.findDistinctTop3ByDivisionContainingOrderByDepartment("Hea"));

        System.out.println("-------------------------Department End-------------------------");
        System.out.println("-------------------------Employee Start-------------------------");

        System.out.println("findByEmail" + employeeRepository.findByEmail("jhelsdonqo@oaic.gov.au"));
        System.out.println("findByFirstNameAndLastNameOrEmail" + employeeRepository.findByFirstNameAndLastNameOrEmail("Jobi", "Helsdon", "fdellatorrequ@soundcloud.com"));
        //  System.out.println("findByFirstNameNot" + employeeRepository.findByFirstNameNot("Jobi"));
        System.out.println("findByLastNameStartingWith" + employeeRepository.findByLastNameStartingWith("Cas"));
        System.out.println("findBySalaryGreaterThan" + employeeRepository.findBySalaryGreaterThan(100_000));

        System.out.println("getEmployeeByEmail" + employeeRepository.getEmployeeByEmail()); // JPQL query
        System.out.println("getEmployeeSalary" + employeeRepository.getEmployeeSalary()); // JPQL query
        System.out.println("getEmployeeByEmail" + employeeRepository.getEmployeeByEmail("jhelsdonqo@oaic.gov.au")); // JPQL query w/ parameter
        System.out.println("getEmployeeByEmail" + employeeRepository.getEmployeeByEmail("jhelsdonqo@oaic.gov.au",80_000)); // JPQL query w/ 2 parameters

        System.out.println("-------------------------Employee End-------------------------");
    }


}
