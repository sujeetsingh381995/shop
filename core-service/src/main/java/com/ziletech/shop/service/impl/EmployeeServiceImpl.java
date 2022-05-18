package com.ziletech.shop.service.impl;


import dto.EmployeeDTO;
import com.ziletech.shop.entity.Employee;
import com.ziletech.shop.repository.EmployeeRepository;
import com.ziletech.shop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setRoll(employee.getRoll());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setName(employee.getName());
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findByAll() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setRoll(employee.getRoll());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setName(employee.getName());
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }


    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setRoll(employeeDTO.getRoll());
        employee.setSalary(employeeDTO.getSalary());
        //Save
        employee = employeeRepository.save(employee);
        employeeDTO.setId(employee.getId());
        return employeeDTO;
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElse(null);
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setRoll(employeeDTO.getRoll());
        employee.setSalary(employeeDTO.getSalary());
        employee = employeeRepository.save(employee);
        return employeeDTO;
    }

}


