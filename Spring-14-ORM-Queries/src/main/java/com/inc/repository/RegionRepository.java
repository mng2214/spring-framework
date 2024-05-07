package com.inc.repository;

import com.inc.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {

    // Display All Regions in Canada
    List<Region> findByCountry(String country);

    // Display all regions in Canada without Dups
    List<Region> findDistinctByCountry(String country);

    // Display all regions with country name includes 'united'
    List<Region> findByCountryContainingIgnoreCase(String regionName);

    // Display all regions with country name includes in order
    List<Region> findByCountryContainingOrderByCountry(String regionName);

    // Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String regionName);


}
