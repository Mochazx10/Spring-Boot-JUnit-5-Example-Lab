package com.codedifferently.intergrationtestexample01.employee.services;

import com.codedifferently.intergrationtestexample01.employee.exceptions.EmployeeNotFoundException;
import com.codedifferently.intergrationtestexample01.employee.models.Employee;

import java.util.List;


public interface EmployeeService { //an Interface called EmployeeService which is used
    //connect classes or methods

    Employee create(String name);//creating a method called create to use with the controller
    List<Employee> getAllEmployees();
    //creating a method called getAllEmployees to use with the controller
    Integer getNumberOfEmployees();
    //creating a method called getEmployeeById to use with the controller.  It has no parameters
    Employee getEmployeeById(int id) throws EmployeeNotFoundException;//creating a method called
    // getEmployeeById to use with the controller.  It has a int id as parameters and it's going to
    //possibly throw an exception

    Employee update(Integer id, String name) throws EmployeeNotFoundException;//creating a method called update
    // to use with the controller. It has a wrapper Integer id and a String name as parameters

    void delete(Integer id);//creating a method called delete with a Wrapper Integer id to use with the controller


    Object setNewEmployee(Object any);
}
