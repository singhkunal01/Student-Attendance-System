package org.project.service;

import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecord;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Service
public interface Service {
    // to fetch all students details
    List<StudentRecord> getAllStudentsDetails();

    // to fetch details of single student on the basis of username
    StudentRecord studentData(String username);

    // inserting the attendance as "Present"
    boolean attendanceAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord);
    // inserting the attendance as "Leave"
    boolean leaveAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord);
    // validation check
    boolean checkValidityForApplying(Long rollNumber, LocalDate attendanceDate);

    // fetching student details using roll number
    List<StudentAttendanceRecord> getStudentDetailsUsingRollNumber(Long rollNumber);
    // to update the status of student attendance & leaves
    boolean updateStatusOfStudent(Long rollNumber,String status,LocalDate dateOfAttendance);

}
