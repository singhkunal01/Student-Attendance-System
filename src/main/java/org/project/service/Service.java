package org.project.service;

import org.project.model.StudentRecord;

import java.util.List;

@org.springframework.stereotype.Service
public interface Service {
    List<StudentRecord> getAllStudentsDetails ();

}
