package org.project.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentRecord {
    private String studentUsername, studentName, course, branch;
    private int currentYear;
    private Long rollNumber;
    private LocalDate dateOfBirth;

    public StudentRecord() {
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentRecord { " +
                "studentUsername='" + studentUsername + '\'' +
                ", studentName='" + studentName + '\'' +
                ", course='" + course + '\'' +
                ", branch='" + branch + '\'' +
                ", rollNumber=" + rollNumber +
                ", currentYear=" + currentYear +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
