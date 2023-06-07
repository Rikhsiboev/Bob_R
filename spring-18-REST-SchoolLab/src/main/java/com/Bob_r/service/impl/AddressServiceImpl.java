package com.Bob_r.service.impl;

import com.Bob_r.client.CountryApiClient;
import com.Bob_r.client.WeatherApiClient;
import com.Bob_r.dto.AddressDTO;
import com.Bob_r.entity.Address;
import com.Bob_r.util.MapperUtil;
import com.Bob_r.repository.AddressRepository;
import com.Bob_r.service.AddressService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Value("${access_key}")
    private String accessKey;

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final WeatherApiClient weatherApiClient;
    private final CountryApiClient countryApiClient;


    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, WeatherApiClient weatherApiClient, CountryApiClient countryApiClient) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.weatherApiClient = weatherApiClient;

        this.countryApiClient = countryApiClient;
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO findById(Long id) throws Exception {
        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new Exception("No Address Found!"));
        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());
        //we will get the current temperature and set based on city, return dto
        addressDTO.setCurrentTemperature(retrieveTemperatureByCity(addressDTO.getCity()));
        //we will get the flag link based on the country provided then return dto
        addressDTO.setFlag(retrieveFlagByCountry(addressDTO.getCountry()));

        return addressDTO;
    }

    private String retrieveFlagByCountry(String country) {
        return countryApiClient.getCountryInfo(country).get(0).getFlags().getPng();
    }


    private Integer retrieveTemperatureByCity(String city) {

           return weatherApiClient.getCurrentWeather(accessKey,city).getCurrent().getTemperature();
        }



    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new Exception("No Address Found!"));

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(addressDTO.getId());

        if (foundAddress.isPresent()) {
            throw new Exception("Address Already Exists!");
        }

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

}