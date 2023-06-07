package com.Bob_r.service.serviceIMP;


import com.Bob_r.dto.AddressDTO;
import com.Bob_r.entity.Address;
import com.Bob_r.entity.Customer;
import com.Bob_r.mapper.MapperUtil;
import com.Bob_r.repository.AddressRepository;
import com.Bob_r.service.AddressService;
import com.Bob_r.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final CustomerService customerService;

    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerService customerService, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.customerService = customerService;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> getAddresses() {
        List<Address> list = addressRepository.findAll();
        return list.stream().map(obj -> mapperUtil.convert(obj, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        Long addressId = addressDTO.getId();

        Address address = mapperUtil.convert(addressDTO, new Address());

        addressRepository.findById(addressId).ifPresent(dbAddress -> {
            dbAddress.setName(address.getName());
            dbAddress.setZipCode(address.getZipCode());
            dbAddress.setStreet(address.getStreet());
            dbAddress.setCustomer(address.getCustomer());

            addressRepository.save(dbAddress);
        });
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        addressRepository.save(mapperUtil.convert(addressDTO,new Address()));
        return addressDTO;
    }

    @Override
    public List<AddressDTO> getAddressesStartsWith(String keyword) {
        List<Address> list = addressRepository.findAllByStreetStartingWith(keyword);
        return list.stream().map(obj -> mapperUtil.convert(obj, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressesByCustomerId(Long id) {
        List<Address> list = addressRepository.retrieveByCustomerId(id);
        return list.stream().map(obj -> mapperUtil.convert(obj, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressesByCustomerAndName(Long customerId, String name) {

        Customer customer = mapperUtil.convert(customerService.findById(customerId), new Customer());
        List<Address> list = addressRepository.findAllByCustomerAndName(customer,name);
        return list.stream().map(obj -> mapperUtil.convert(obj, new AddressDTO())).collect(Collectors.toList());
    }
}
