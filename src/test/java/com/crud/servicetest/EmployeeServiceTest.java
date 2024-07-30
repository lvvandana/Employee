package com.crud.servicetest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.crud.repository.EmployeeRepository;
import com.crud.entity.EmployeeEntity;
import com.crud.service.EmployeeServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;
    
    @BeforeEach
	void init_mocks() {
		MockitoAnnotations.initMocks(this);
	}

    @Test
    public void whenSaveEmployee_shouldReturnEmployee() {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmployeeName("Test Name");
        employee.setEmployeeSalary(100);


       when(employeeRepository.save(ArgumentMatchers.any(EmployeeEntity.class))).thenReturn(employee);

        EmployeeEntity created = employeeService.saveEmployee(employee);

        assertThat(created.getEmployeeName()).isSameAs(employee.getEmployeeName());
        verify(employeeRepository).save(employee);
    }

}
