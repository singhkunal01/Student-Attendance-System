package org.project.service;

import org.project.dao.Dao;
import org.project.model.StudentRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service

public class ServiceImple implements Service {

    @Autowired
    private Dao dao;
    @Override
    public List<StudentRecord> getAllStudentsDetails() {
        return dao.getAllStudentsDetails();
    }
}
