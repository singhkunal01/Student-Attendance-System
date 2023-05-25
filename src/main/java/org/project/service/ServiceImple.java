package org.project.service;

import org.project.dao.DaoImpl;
import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
@org.springframework.stereotype.Service

public class ServiceImple implements Service {

    @Autowired
    private DaoImpl dao;
    @Override
    public List<StudentRecord> getAllStudentsDetails() {
        return dao.getAllStudentsDetails();
    }

    @Override
    public StudentRecord studentData(String username) {
        return dao.studentData(username);
    }

    @Override
    public boolean attendanceAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord) {
        return dao.attendanceAppliedInsertion(studentAttendanceRecord);

    }

    @Override
    public boolean leaveAppliedInsertion(StudentAttendanceRecord studentAttendanceRecord) {
        return dao.leaveAppliedInsertion(studentAttendanceRecord);
    }

    @Override
    public boolean checkValidityForApplying(Long rollNumber, LocalDate attendanceDate,String attendanceType) {
        return dao.checkValidityForApplying(rollNumber,attendanceDate,attendanceType);
    }

    @Override
    public StudentAttendanceRecord getStudentDetailsUsingUsername(Long rollNumber) {
        return dao.getStudentDetailsUsingUsername(rollNumber);
    }
}
