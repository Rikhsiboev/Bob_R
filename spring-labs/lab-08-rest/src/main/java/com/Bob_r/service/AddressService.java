package com.Bob_r.service;

import com.Bob_r.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAddresses();

    void updateAddress(AddressDTO addressDTO);

    AddressDTO createAddress(AddressDTO addressDTO);

    List<AddressDTO> getAddressesStartsWith(String keyword);

    List<AddressDTO> getAddressesByCustomerId(Long id);

    List<AddressDTO> getAddressesByCustomerAndName(Long id,String name);

}
