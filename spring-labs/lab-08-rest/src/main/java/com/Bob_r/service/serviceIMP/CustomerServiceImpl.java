package com.Bob_r.service.serviceIMP;


import com.Bob_r.dto.CustomerDTO;
import com.Bob_r.entity.Customer;
import com.Bob_r.mapper.MapperUtil;
import com.Bob_r.repository.CustomerRepository;
import com.Bob_r.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(new Customer());
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(obj -> mapperUtil.convert(obj,new CustomerDTO())).collect(Collectors.toList());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Long customerId = customerDTO.getId();

       Customer customer = mapperUtil.convert(customerDTO, new Customer());

        customerRepository.findById(customerId).ifPresent(dbCustomer -> {
            dbCustomer.setFirstName(customer.getFirstName());
            dbCustomer.setLastName(customer.getLastName());
            dbCustomer.setUserName(customer.getUserName());
            dbCustomer.setEmail(customer.getEmail());
            dbCustomer.setAddressList(customer.getAddressList());

            customerRepository.save(dbCustomer);
        });
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerRepository.save(mapperUtil.convert(customerDTO, new Customer()));
        return customerDTO;
    }

    @Override
    public CustomerDTO getByCustomerEmail(String email) {
        Customer customer = customerRepository.retrieveByCustomerEmail(email);
        return mapperUtil.convert(customer,new CustomerDTO());
    }
}
