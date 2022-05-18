package com.ziletech.shop.service.impl;

import com.ziletech.shop.service.SalaryService;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Override
    public String printableSalary(Long id, String salary) {
        return "User id :" + id + " is having salary : " + salary;
    }
}
