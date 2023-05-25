package org.project.service;

import org.project.model.StudentRecord;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {
    // to fetch all students details
    List<StudentRecord> getAllStudentsDetails ();

    // to fetch details of single student on the basis of username
    StudentRecord studentData(String username);

}
