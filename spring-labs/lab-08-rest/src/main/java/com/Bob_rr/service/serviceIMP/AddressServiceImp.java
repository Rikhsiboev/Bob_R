package com.Bob_rr.service.serviceIMP;

import com.Bob_rr.mapper.MapperUtil;
import com.Bob_rr.dto.AddressDTO;
import com.Bob_rr.entity.Address;
import com.Bob_rr.repository.AddressRepository;
import com.Bob_rr.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AddressServiceImp implements AddressService {

    private final com.Bob_rr.repository.AddressRepository addressRepository;
    private final MapperUtil mapperUtil1;

    public AddressServiceImp(AddressRepository addressRepository, MapperUtil mapperUtil1) {
        this.addressRepository = addressRepository;
        this.mapperUtil1 = mapperUtil1;
    }

    @Override
    public List<AddressDTO> getAddressList() {
        List<Address> all = addressRepository.findAll();
        return all.stream().map(list-> mapperUtil1.convert(list,new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {

        Address convert = mapperUtil1.convert(addressDTO, new Address());
        œ

        addressRepository.save();


        return null;
    }


}
