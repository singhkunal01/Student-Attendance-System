package org.project.dao;

import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecordRowMapper;
import org.project.model.StudentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
public class DaoImpl implements Dao {
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

    @Override
    public boolean attendanceAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord) {
        String query = "Insert into student_attendancerecord values(?,?,?,?,?) ";
        int rowsInserted = this.jdbcTemplate.update(query, studentAttendanceRecord.getRollNumber(), studentAttendanceRecord.getStudentName(),
                studentAttendanceRecord.getAttendanceDate(), studentAttendanceRecord.getAttendanceType(), studentAttendanceRecord.getReason());
        return rowsInserted > 0;
    }

    @Override
    public boolean leaveAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord) {
        String query = "Insert into student_attendancerecord values(?,?,?,?,?) ";
        int rowsInserted = this.jdbcTemplate.update(query, studentAttendanceRecord.getRollNumber(), studentAttendanceRecord.getStudentName(),
                studentAttendanceRecord.getAttendanceDate(), studentAttendanceRecord.getAttendanceType(), studentAttendanceRecord.getReason());
        return rowsInserted > 0;
    }

    @Override
    public boolean checkValidityForApplying(Long rollNumber, LocalDate attendanceDate,String attendanceType) {
        String query = "SELECT count(*) from student_attendancerecord where rollNumber = ? and dateOfAttendance = ? and attendanceType = ?";
        int result = 0;
        if (ChronoUnit.DAYS.between(attendanceDate, LocalDate.now()) >= 0) {
            result = this.jdbcTemplate.queryForObject(query, new Object[]{rollNumber, attendanceDate,attendanceType}, Integer.class);
//            System.out.println(ChronoUnit.DAYS.between(attendanceDate, LocalDate.now()));
        }
        return result == 0;
    }

    @Override
    public StudentAttendanceRecord getStudentDetailsUsingUsername(Long rollNumber) {
        StudentAttendanceRecord studentAttendanceRecord = null;
        String query = "select *from student_attendancerecord where rollNumber = ? ";
        studentAttendanceRecord = this.jdbcTemplate.queryForObject(query, new Object[]{rollNumber}, new BeanPropertyRowMapper<>(StudentAttendanceRecord.class));
        return studentAttendanceRecord;
    }
}
