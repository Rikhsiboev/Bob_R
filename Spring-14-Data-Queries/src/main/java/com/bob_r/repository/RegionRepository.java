package com.bob_r.repository;

import com.bob_r.entity.Employee;
import com.bob_r.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {
    //Display all regions in Canada
    List<Region> findByCountry (String country);
    List<Region> getByCountry (String country);
    //Display all region with Country name include United
    List<Region> findByCountryContaining(String country);
    //Display all region with Country name include United in order (region)
    List<Region>findByCountryContainsOrderByRegionDesc(String country);
    //Display top 2 regions in United States (limit)
    List<Region>findTop2ByCountry(String country);
    List<Region> findTopByCountryContainsOrderByRegion(String country);





}
