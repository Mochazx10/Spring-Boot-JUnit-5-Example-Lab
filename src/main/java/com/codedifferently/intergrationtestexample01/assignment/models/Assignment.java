package com.codedifferently.intergrationtestexample01.assignment.models;

public class Assignment {
    private Integer id;
    private String title;

    public Assignment(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Assignment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private static int currentId = 1;

    public static Assignment builder(String title){
        Assignment assignment = new Assignment(currentId, title);
        currentId++;
        return assignment;
    }
}
