package com.devit.employee.service;

import com.devit.employee.bean.Employee;
import com.devit.employee.dao.EmployeeDao;
import com.devit.employee.dto.EmployeeDto;
import com.devit.employee.dto.ResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public ResponseDto<EmployeeDto> save(EmployeeDto employeeDto) {
        ResponseDto<EmployeeDto> responseDto = new ResponseDto<>();
        if(employeeDao.existsEmployeeByUsername(employeeDto.getUsername())){
            responseDto.setCode(-2);
            responseDto.setMessage("employee username already in use");
        }else{
            if(employeeDao.existsEmployeeByEmail(employeeDto.getEmail())){
                responseDto.setCode(-3);
                responseDto.setMessage("email username already in use");
            }else{
                Employee employee = new Employee();
                BeanUtils.copyProperties(employeeDto,employee);
                employeeDao.save(employee);
                responseDto.setCode(1);
                responseDto.setMessage("employee added with success");
                responseDto.setPayload(employeeDto);
            }
        }
        return responseDto;
    }
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Employee findByUsername(String department) {
        return employeeDao.findEmployeeByUsername(department);
    }
}
