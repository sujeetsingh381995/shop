package com.ziletech.shop.service;

import dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    UserDTO findById(Long id);
}
