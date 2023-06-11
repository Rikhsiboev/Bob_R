package com.Bob_r.service;

import com.Bob_r.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    CustomerDTO findById(Long id);

    List<CustomerDTO> findAll();

    void updateCustomer(CustomerDTO customerDTO);

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    CustomerDTO getByCustomerEmail(String email);

    boolean existById(Long customerId);
}
