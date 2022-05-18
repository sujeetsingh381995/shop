package com.ziletech.shop.service.impl;

import dto.AddressDTO;
import dto.UserDTO;
import com.ziletech.shop.entity.Address;
import com.ziletech.shop.entity.User;
import com.ziletech.shop.repository.UserRepository;
import com.ziletech.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setGender(userDTO.getGender());
        user = userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setGender(user.getGender());
        //list type in userDTO
        List<AddressDTO> addressDTOList = new ArrayList<>();
        for (Address address : user.getAddresses()) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setId(address.getId());
            addressDTO.setCity(address.getCity());
            addressDTO.setState(address.getState());
            addressDTO.setPinCode(address.getPinCode());
            addressDTOList.add(addressDTO);

        }
        userDTO.setAddresses(addressDTOList);
        return userDTO;
    }
}


