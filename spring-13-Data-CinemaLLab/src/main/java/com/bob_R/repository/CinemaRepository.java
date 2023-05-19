package com.bob_R.repository;

import com.bob_R.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameOrderByName(String name);

    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsorName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocation_Country(String countryName);


    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name, String sponsoredName);

    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c from Cinema c where c.id=?1")
    List<Cinema> getCinemaNameId(@Param("id") Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country

    @Query (value="select * from cinema c join location l on c.id=l.id where l.country=?1",nativeQuery = true)
    List<Cinema> readCinemaLocationCountry(@Param("country") String country);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query (value="select * from cinema where name ILIKE concat('%',?1,'%') " +
            "or sponsored_name ILIKE concat('%',?1,'%')"
            ,nativeQuery = true)
    List<Cinema> readCinemaNameOrSponsoredName(@Param("pattern")String pattern);

    //Write a native query to sort all cinemas by name
    @Query (value="select * from cinema order by name desc",nativeQuery = true)
    List<Cinema> readCinemaNameSort();

}
