package com.ziletech.shop.controller;

import dto.EmployeeDTO;
import com.ziletech.shop.service.EmployeeService;
import com.ziletech.shop.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalaryService salaryService;

    @GetMapping("employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") long id) {
        EmployeeDTO employee = employeeService.findById(id);
        employee.setPrintableSalary(salaryService.printableSalary(employee.getId(), employee.getSalary()));
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        List<EmployeeDTO> employeeList = employeeService.findByAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping("employees")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employee){
        EmployeeDTO saveEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(saveEmployee,HttpStatus.OK);
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employee){
        employee.setId(id);
        EmployeeDTO saveEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(saveEmployee,HttpStatus.OK);
    }


}
