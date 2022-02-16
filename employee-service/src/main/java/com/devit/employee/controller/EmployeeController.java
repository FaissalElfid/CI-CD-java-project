package com.devit.employee.controller;

import com.devit.employee.bean.Employee;
import com.devit.employee.dto.DepartementDto;
import com.devit.employee.dto.EmployeeDto;
import com.devit.employee.required.DepartementService;
import com.devit.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired private EmployeeService employeeService;
    @Autowired private DepartementService departementService;

    @GetMapping("/{username}")
    public Employee findByUsername(@RequestParam("username") String username) {
        return employeeService.findByUsername(username);
    }
    @GetMapping("/")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping("/")
    public long save(@RequestBody EmployeeDto employeeDto) {
        DepartementDto newDepartementDto = departementService.findDepartementByLibelle(employeeDto.getDepartement_libelle());
        if(newDepartementDto == null){
            return -1;
        }else{
            return employeeService.save(employeeDto);
        }
    }
}
