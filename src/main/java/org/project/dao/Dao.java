package org.project.dao;

import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface Dao {
    List<StudentRecord> getAllStudentsDetails ();
    StudentRecord studentData(String username);
    boolean attendanceAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord);
    boolean leaveAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord);

    boolean checkValidityForApplying(Long rollNumber, LocalDate attendanceDate,String attendanceType);

    StudentAttendanceRecord getStudentDetailsUsingUsername(Long rollNumber);


}
