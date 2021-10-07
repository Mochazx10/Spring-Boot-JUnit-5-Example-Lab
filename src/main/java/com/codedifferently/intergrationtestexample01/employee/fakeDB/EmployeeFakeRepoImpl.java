package com.codedifferently.intergrationtestexample01.employee.fakeDB;

import com.codedifferently.intergrationtestexample01.employee.models.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeFakeRepoImpl implements EmployeeFakeRepo {
    private List<Employee> employees;

    public EmployeeFakeRepoImpl(){
        employees = new ArrayList<>();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        for(Employee e: employees){
            if (e.getId() == id){
                employee = e;
                break;
            }
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public void delete(int id) {
        for(int i=0; i<  employees.size(); i++){
            if(employees.get(i).getId() == id){
                employees.remove(i);
            }
        }
    }
}
