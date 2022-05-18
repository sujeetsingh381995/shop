package com.ziletech.shop.service;

import dto.AddressDTO;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {
    AddressDTO saveAddress(AddressDTO addressDTO);
}
