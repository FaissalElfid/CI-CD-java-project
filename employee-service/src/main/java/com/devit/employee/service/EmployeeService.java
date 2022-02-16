package com.devit.employee.service;

import com.devit.employee.bean.Employee;
import com.devit.employee.dao.EmployeeDao;
import com.devit.employee.dto.EmployeeDto;
import com.devit.employee.required.DepartementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public long save(EmployeeDto employeeDto) {
        if(employeeDao.existsEmployeeByUsername(employeeDto.getUsername())){
            return -2;
        }else{
            if(employeeDao.findEmployeeByEmail(employeeDto.getEmail()) == null){
                return -3;
            }else{
                Employee employee = new Employee();
                BeanUtils.copyProperties(employeeDto,employee);
                employeeDao.save(employee);
                return 1;
            }
        }
    }
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
    public Employee findByUsername(String department) {
        return employeeDao.findEmployeeByUsername(department);
    }
}
