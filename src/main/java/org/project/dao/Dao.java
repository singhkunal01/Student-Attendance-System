package org.project.dao;

import org.project.model.StudentRecordRowMapper;
import org.project.model.StudentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Dao implements DaoImpl {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<StudentRecord> getAllStudentsDetails() {
        List<StudentRecord> studentRecords = null;
        String query = "select *from student_record";
        studentRecords = this.jdbcTemplate.query(query, new StudentRecordRowMapper());
        return studentRecords;
    }

    @Override
    public StudentRecord studentData(String username) {
        StudentRecord studentRecord = null;
        String query = "select *from student_record where student_username = ? ";
        studentRecord = this.jdbcTemplate.queryForObject(query, new Object[]{username}, new StudentRecordRowMapper());
        return studentRecord;
    }
}
