package com.crud.controllertest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import com.crud.controller.EmployeeController;
import com.crud.entity.EmployeeEntity;
import com.crud.service.EmployeeServiceImpl;
import com.crud.util.EmployeeJsonUtil;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = EmployeeController.class)
public class EmployeeControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private EmployeeServiceImpl service;

	    @Test
	    public void createEmployee_whenPostMethod() throws Exception {

	        EmployeeEntity employee = new EmployeeEntity();
	        employee.setEmployeeName("Test Name");
	        employee.setEmployeeSalary(100);
	        given(service.saveEmployee(employee)).willReturn(employee);

	        mockMvc.perform(post("/employee")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(EmployeeJsonUtil.toJson(employee)))
	                .andExpect(status().isOk());
	             
	    }

}
