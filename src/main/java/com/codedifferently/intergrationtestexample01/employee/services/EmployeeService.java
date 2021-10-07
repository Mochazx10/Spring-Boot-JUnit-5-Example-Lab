package com.codedifferently.intergrationtestexample01.employee.services;

import com.codedifferently.intergrationtestexample01.employee.exceptions.EmployeeNotFoundException;
import com.codedifferently.intergrationtestexample01.employee.models.Employee;

import java.util.List;


public interface EmployeeService {

    Employee create(String name);
    List<Employee> getAllEmployees();
    Integer getNumberOfEmployees();
    Employee getEmployeeById(int id) throws EmployeeNotFoundException;
    Employee update(Integer id, String name) throws EmployeeNotFoundException;
    void delete(Integer id);
}
