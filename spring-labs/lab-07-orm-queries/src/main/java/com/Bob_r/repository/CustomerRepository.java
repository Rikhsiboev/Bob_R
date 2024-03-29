package com.Bob_r.repository;

import com.Bob_r.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Write a derived query to get all customer by id
    Optional<Customer> findById(Long id);
    //Write a JPQL query to get customer by email
    @Query("SELECT c FROM Customer  c WHERE c.email = ?1")
    List<Customer> retrieveByCustomerEmail(String email);



}
