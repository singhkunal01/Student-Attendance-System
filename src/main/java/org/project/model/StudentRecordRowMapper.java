package org.project.model;

import org.project.model.StudentRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentRecordRowMapper implements RowMapper<StudentRecord> {

    @Override
    public StudentRecord mapRow(ResultSet resultSet, int i) throws SQLException {

        StudentRecord studentRecord = new StudentRecord();
        studentRecord.setStudentUsername(resultSet.getString(1));
        studentRecord.setStudentName(resultSet.getString(2));
        studentRecord.setRollNumber(resultSet.getLong(3));
        studentRecord.setCourse(resultSet.getString(4));
        studentRecord.setBranch(resultSet.getString(5));
        studentRecord.setDateOfBirth(resultSet.getDate(6).toLocalDate());
        studentRecord.setCurrentYear(resultSet.getInt(7));
        return studentRecord;
    }
}
