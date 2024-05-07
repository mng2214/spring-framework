package com.inc.bootstrap;

import com.inc.repository.DepartmentRepository;
import com.inc.repository.RegionRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
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





        System.out.println("-------------------------Department End-------------------------");
    }


}
