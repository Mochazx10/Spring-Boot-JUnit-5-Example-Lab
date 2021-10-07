package com.codedifferently.intergrationtestexample01.employee.models;

public class Employee {
    private Integer id;
    private String name;

    public Employee() {
    }

    private Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static int currentId = 1;

    public static Employee builder(String name){
        Employee employee = new Employee(currentId,name);
        currentId++;
        return employee;
    }


}
