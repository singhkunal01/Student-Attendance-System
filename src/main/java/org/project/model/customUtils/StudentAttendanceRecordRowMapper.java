package org.project.model.customUtils;

import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentAttendanceRecordRowMapper implements RowMapper<StudentAttendanceRecord> {

    @Override
    public StudentAttendanceRecord mapRow(ResultSet resultSet, int i) throws SQLException {

        StudentAttendanceRecord studentRecord = new StudentAttendanceRecord();
        studentRecord.setRollNumber(resultSet.getLong(1));
        studentRecord.setStudentName(resultSet.getString(2));
        studentRecord.setAttendanceDate(resultSet.getDate(3).toLocalDate());
        studentRecord.setAttendanceType(resultSet.getString(4));
        studentRecord.setReason(resultSet.getString(5));
        studentRecord.setApprovalRejectionStatus(resultSet.getString(6));
        return studentRecord;
    }
}
