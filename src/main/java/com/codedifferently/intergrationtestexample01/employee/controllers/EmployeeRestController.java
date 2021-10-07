package com.codedifferently.intergrationtestexample01.employee.controllers;

import com.codedifferently.intergrationtestexample01.employee.models.Employee;
import com.codedifferently.intergrationtestexample01.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService){
      this.employeeService = employeeService;
  }

  @PostMapping("/")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
      HttpStatus status = HttpStatus.CREATED;
      Employee saved = employeeService.create(employee.getName());
      return new ResponseEntity<>(saved,status);
  }

  //Todo: Create a Get Method that returns all items with a status code of 200


  //Todo: Create a PUT Method that updates a status code with 204


  //Todo: Create a DELETE method that removes the item and returns a status code of 202

}
