package com.ziletech.shop.controller;

import com.ziletech.shop.repository.UserRepository;
import com.ziletech.shop.service.AddressService;
import dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v3/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("")
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO address) {
        AddressDTO saveAddress = addressService.saveAddress(address);
        return new ResponseEntity<>(saveAddress, HttpStatus.OK);
    }

}
