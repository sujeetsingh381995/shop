package com.ziletech.shop.service;

import dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeDTO findById(Long id);

    List<EmployeeDTO> findByAll();

    EmployeeDTO saveEmployee(EmployeeDTO employee);

    EmployeeDTO updateEmployee(EmployeeDTO employee);
}
