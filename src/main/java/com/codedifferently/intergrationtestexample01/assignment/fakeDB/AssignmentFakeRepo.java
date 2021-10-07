package com.codedifferently.intergrationtestexample01.assignment.fakeDB;

import com.codedifferently.intergrationtestexample01.assignment.models.Assignment;

import java.util.List;

public interface AssignmentFakeRepo {
    Assignment findById(int id);
    List<Assignment> findAll();
    Assignment save(Assignment assignment);
    void delete(int id);
}
