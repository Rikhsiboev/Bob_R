package com.Bob_rr.service;

import com.Bob_rr.dto.AddressDTO;
import com.Bob_rr.entity.Address;

import java.util.List;

public interface AddressService {
    List<AddressDTO> getAddressList();
    AddressDTO createAddress(AddressDTO addressDTO);
}
