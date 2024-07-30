package com.crud.controller;


import com.crud.entity.EmployeeEntity;
import com.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {
	
	
	@Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employee/{id}")
    public EmployeeEntity updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeEntity employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteDepartmentById(id);
    }

}
