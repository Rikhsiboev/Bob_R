package com.Bob_rr.controller;

import com.Bob_rr.model.ResponseWrapper;
import com.Bob_rr.service.serviceIMP.AddressServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/address")
public class AddressController {

private final AddressServiceImp addressServiceImp;

    public AddressController(AddressServiceImp addressServiceImp) {
        this.addressServiceImp = addressServiceImp;
    }


    @GetMapping()
    public ResponseEntity<ResponseWrapper> getAddressList() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                new ResponseWrapper("Address are successfully retrieved",
                addressServiceImp.getAddressList(),
                        HttpStatus.ACCEPTED));
    }

    @GetMapping("/create")
    public ResponseEntity<ResponseWrapper> createAddress(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseWrapper("Create address are successfully retrieved",
                        addressServiceImp.createAddress(),
                        HttpStatus.ACCEPTED));
    }



}
