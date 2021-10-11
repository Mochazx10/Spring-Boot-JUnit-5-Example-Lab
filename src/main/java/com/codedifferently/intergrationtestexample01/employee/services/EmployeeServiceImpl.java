package com.codedifferently.intergrationtestexample01.employee.services;

import com.codedifferently.intergrationtestexample01.employee.exceptions.EmployeeNotFoundException;
import com.codedifferently.intergrationtestexample01.employee.fakeDB.EmployeeFakeRepo;
import com.codedifferently.intergrationtestexample01.employee.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeFakeRepo fakeRepo; //fake repo variable

    @Autowired
    public EmployeeServiceImpl(EmployeeFakeRepo fakeRepo){
        this.fakeRepo = fakeRepo;
    }//

    @Override
    public Employee create(String name) { //a method
        Employee employee = Employee.builder(name);
        fakeRepo.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return fakeRepo.findAll();
    }//a method

    @Override
    public Integer getNumberOfEmployees() {
        return fakeRepo.findAll().size();
    }//a method

    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException{// a method
        Employee employee = fakeRepo.findById(id);
        if (employee == null)
            throw new EmployeeNotFoundException();
        return employee;
    }

    @Override
    public Employee update(Integer id, String name) throws EmployeeNotFoundException{// a method
        Employee employee = fakeRepo.findById(id);
        if (employee == null)
            throw new EmployeeNotFoundException();
        employee.setName(name);
        fakeRepo.save(employee);
        return employee;
    }

    @Override
    public void delete(Integer id) {
        fakeRepo.delete(id);
    }// a method

    @Override
    public Object setNewEmployee(Object any) { // a method
        return null;
    }


}
