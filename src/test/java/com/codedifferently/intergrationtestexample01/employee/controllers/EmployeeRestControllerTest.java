package com.codedifferently.intergrationtestexample01.employee.controllers;

import com.codedifferently.intergrationtestexample01.JsonUtil;
import com.codedifferently.intergrationtestexample01.employee.models.Employee;
import com.codedifferently.intergrationtestexample01.employee.services.EmployeeService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
//annotates mean to use the SpringBoot container to extend the SpringExtension class
@WebMvcTest(value = EmployeeRestController.class)
// put the EmployeeRestController class in the SpringBoot app and use it with the Web
//Model View Controller Test bean
public class EmployeeRestControllerTest {

    @Autowired
    private WebApplicationContext wac;
    // Used to inject WebApplicationContext to the local variable wac

    @MockBean
    private EmployeeService service;
    // the annotation used to simulate a Mock test which injected the EmployeeService class
    //with the local variable service

    private MockMvc mockMvc;//declaring the variable mockMvc

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    //a method  called setup that is using the keyword this to declare mockMvc is associated with this method.
    //the method is using the MockMvcBuilder object and calling the  webAppContext Setup interface which is autowired
    // to access the wac variable

    @Test//annotation that ask for testing
    public void createNewEmployee() throws Exception { //creating a method that will possibly throw an exception
        Employee bob = Employee.builder("Bob");//Constructor
        BDDMockito.given(service.create(Mockito.any())).willReturn(bob);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees/")
                        .contentType((MediaType.APPLICATION_JSON))
                        .content(JsonUtil.toJson(bob)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is("Bob")));
    }

    //Todo: Create Test for Get Method that returns all employees with a status code of 200
    @Test
    public void getEmployeeId(Employee peter) throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(Employee.builder("Omar"));
        BDDMockito.given(service.getAllEmployees()).willReturn(employees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/{id}/")
                        .contentType((MediaType.APPLICATION_JSON))
                        .content(JsonUtil.toJson(employees)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }


    //Todo: Create Test for PUT Method that updates a employee and returns status code with 204
    @Test
    public void setNewEmployee() throws Exception {
        Employee bob = Employee.builder("Bob");
        BDDMockito.given(service.setNewEmployee(Mockito.any())).willReturn(bob);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees/")
                        .contentType((MediaType.APPLICATION_JSON))
                        .content(JsonUtil.toJson(bob)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }


    //Todo: Create Test for DELETE method that removes the employee and returns a status code of 202
    @Test
    public void deleteNewEmployee() throws Exception {
        Employee bob = Employee.builder("Bob");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/employees/")
                        .contentType((MediaType.APPLICATION_JSON))
                        .content(JsonUtil.toJson(bob)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

}
