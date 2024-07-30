package com.crud.service;

import com.crud.entity.EmployeeEntity;
import com.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeEntity> fetchAllEmployees() {
        List<EmployeeEntity> allEmployees = employeeRepository.findAll();
        return allEmployees;
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public EmployeeEntity updateEmployeeById(Long id, EmployeeEntity employee) {
        Optional<EmployeeEntity> employee1 = employeeRepository.findById(id);

        if (employee1.isPresent()) {
            EmployeeEntity originalEmployee = employee1.get();

            if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
                originalEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if (Objects.nonNull(employee.getEmployeeSalary()) && employee.getEmployeeSalary() != 0) {
                originalEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            }
            return employeeRepository.save(originalEmployee);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";
    }
}
