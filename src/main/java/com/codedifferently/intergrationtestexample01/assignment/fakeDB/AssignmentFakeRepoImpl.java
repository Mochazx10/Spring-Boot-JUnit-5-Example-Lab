package com.codedifferently.intergrationtestexample01.assignment.fakeDB;

import com.codedifferently.intergrationtestexample01.assignment.models.Assignment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssignmentFakeRepoImpl implements AssignmentFakeRepo{
    private List<Assignment> assignments;

    public AssignmentFakeRepoImpl() {
        assignments = new ArrayList<>();
    }

    @Override
    public Assignment findById(int id) {
        Assignment assignment = null;
        for(Assignment a: assignments){
            if (a.getId() == id){
                assignment = a;
                break;
            }
        }
        return assignment;
    }

    @Override
    public List<Assignment> findAll() {
        return assignments;
    }

    @Override
    public Assignment save(Assignment assignment) {
        assignments.add(assignment);
        return assignment;
    }

    @Override
    public void delete(int id) {
        for(int i = 0; i < assignments.size(); i++){
            if(assignments.get(i).getId() == id){
                assignments.remove(i);
            }
        }
    }
}
