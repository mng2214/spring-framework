package com.inc.repository;

import com.inc.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    // Display All Regions in Canada

    List<Region> findByCountry(String country);



}
