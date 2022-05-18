package com.ziletech.shop.service.impl;

import dto.AddressDTO;
import com.ziletech.shop.entity.Address;
import com.ziletech.shop.entity.User;
import com.ziletech.shop.repository.AddressRepository;
import com.ziletech.shop.repository.UserRepository;
import com.ziletech.shop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setPinCode(addressDTO.getPinCode());
        address.setContactNumber(addressDTO.getContactNumber());
        User user = userRepository.findById(addressDTO.getUser().getId()).orElse(null);
        address.setUser(user);
        address = addressRepository.save(address);
        addressDTO.setId(address.getId());
        return addressDTO;
    }

}
