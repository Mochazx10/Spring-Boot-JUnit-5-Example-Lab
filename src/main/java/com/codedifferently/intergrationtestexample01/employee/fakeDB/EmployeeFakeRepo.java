package com.codedifferently.intergrationtestexample01.employee.fakeDB;

import com.codedifferently.intergrationtestexample01.employee.models.Employee;

import java.util.List;

public interface EmployeeFakeRepo {
    Employee findById(int id);
    List<Employee> findAll();
    Employee save(Employee employee);
    void delete(int id);
}
