package com.codedifferently.intergrationtestexample01.employee.services;

import com.codedifferently.intergrationtestexample01.employee.exceptions.EmployeeNotFoundException;
import com.codedifferently.intergrationtestexample01.employee.models.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    public void createTest(){
        employeeService.create("First Employee");
        Employee expected = Employee.builder("Bob");
        Employee actual = employeeService.create("Bob");
        Assertions.assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void getNumberOfEmployeesTest(){
        employeeService.create("First Employee");
        Integer expected = 2;
        employeeService.create("Bob");
        Integer actual = employeeService.getNumberOfEmployees();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeByIdTest() throws EmployeeNotFoundException{
        String expected = "Test Employee";
        Employee sampleEmployee = employeeService.create("Test Employee");
        int employeeId = sampleEmployee.getId();
        Employee employee = employeeService.getEmployeeById(employeeId);
        String actual = employee.getName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getEmployeeByIdNotFoundTest()  {
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->{
            employeeService.getEmployeeById(100);
        });
    }

    @Test
    public void updateTest() throws EmployeeNotFoundException {
        employeeService.create("First Employee");
        String expected = "Name Changed";
        Employee employee = employeeService.update(1, "Name Changed");
        String actual = employee.getName();
        Assertions.assertEquals(expected, actual);
    }


}
