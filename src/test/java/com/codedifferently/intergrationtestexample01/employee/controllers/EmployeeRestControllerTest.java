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


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = EmployeeRestController.class)
public class EmployeeRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private EmployeeService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void createNewEmployee() throws Exception {
        Employee bob =  Employee.builder("Bob");
        BDDMockito.given(service.create(Mockito.any())).willReturn(bob);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/employees")
                        .contentType((MediaType.APPLICATION_JSON))
                        .content(JsonUtil.toJson(bob)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is("Bob")));
    }

    //Todo: Create Test for Get Method that returns all items with a status code of 200


    //Todo: Create Test for PUT Method that updates a status code with 204


    //Todo: Create Test for DELETE method that removes the item and returns a status code of 202


}
