package org.project.dao;

import org.project.model.StudentRecord;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoImpl {
    List<StudentRecord> getAllStudentsDetails ();
    StudentRecord studentData(String username);


}
