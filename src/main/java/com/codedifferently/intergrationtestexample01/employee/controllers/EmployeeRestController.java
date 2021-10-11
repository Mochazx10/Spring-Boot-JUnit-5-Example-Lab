package com.codedifferently.intergrationtestexample01.employee.controllers;

import com.codedifferently.intergrationtestexample01.employee.exceptions.EmployeeNotFoundException;
import com.codedifferently.intergrationtestexample01.employee.models.Employee;
import com.codedifferently.intergrationtestexample01.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:8081")


@RestController
//The RestController annotation is used to define a controller
// and to indicate that the return value of the methods should be  bound to the web response body.
@RequestMapping("/api/employees")
//The RequestMapping annotation that declares that all Apis’ url in the controller will start with whatever
//is in the parameter
public class EmployeeRestController {  //public access modifier and name of the class

    private final EmployeeService employeeService;//private access modifier and name of the INTERFACE

    @Autowired// annotation  used to put EmployeeRestController bean in the setter method
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/") //Annotates what will be created on the request server
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        //The @ResponseBody annotation tells a controller that the object returned is
        // automatically serialized into JSON and passed back into the HttpResponse object.
        HttpStatus status = HttpStatus.CREATED;//browser status created
        Employee saved = employeeService.create(employee.getName());//
        return new ResponseEntity<>(saved, status);//returning a response entity


        //Todo: Create a Get Method that returns all items with a status code of 200
            @GetMapping("/getEmployeeById") //Annotates what will get the item code status on the request server
            public ResponseEntity<Employee> getEmployeeById (; @PathVariable ) throws EmployeeNotFoundException {
            HttpStatus status3 = HttpStatus.OK;//browser status created
            Employee saved3 = employeeService.getEmployeeById(id.intValue());
            return new ResponseEntity<>(saved3, status3);

            //Todo: Create a PUT Method that updates a status code with 204

            @PutMapping ResponseEntity<Employee> update;
            public HttpStatus status1 = HttpStatus.NO_CONTENT;//browser status created
            Employee saved1 = employeeService.update(employeeService.getEmployeeById(Long id));
            return new ResponseEntity<>(saved1, status1);

            //Todo: Create a DELETE method that removes the item and returns a status code of 202
            @DeleteMapping("/delete") //Annotates what will be deleted on the request server
            public ResponseEntity<Employee> delete (@PathVariable Integer)
                    HttpStatus status1 = HttpStatus.ACCEPTED;//browser status created
            Employee saved2 = employeeService.delete(employeeService.getEmployeeById(Long id));//
            return new ResponseEntity<>(saved2);

    }
        }
    }



