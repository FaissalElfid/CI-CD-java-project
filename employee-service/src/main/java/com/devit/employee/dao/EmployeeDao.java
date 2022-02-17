package com.devit.employee.dao;

import com.devit.employee.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {
    Employee findEmployeeByEmail(String email);
    Employee findEmployeeByUsername(String username);
    Boolean existsEmployeeByUsername(String username);
    Boolean existsEmployeeByEmail(String email);
}
