package com.crud.service;

import com.crud.entity.EmployeeEntity;
import java.util.List;


public interface EmployeeService {
	
	EmployeeEntity saveEmployee(EmployeeEntity employee);

    List<EmployeeEntity> fetchAllEmployees();

    EmployeeEntity getEmployeeById(Long id);

    EmployeeEntity updateEmployeeById(Long id, EmployeeEntity employee);

    String deleteDepartmentById(Long id);

}
