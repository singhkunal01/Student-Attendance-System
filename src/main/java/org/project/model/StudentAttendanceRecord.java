package org.project.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentAttendanceRecord {
    private Long rollNumber;
    private String studentName;
    private LocalDate attendanceDate;
    private String attendanceType;
    private String reason;
    private String approvalRejectionStatus;

    public String getApprovalRejectionStatus() {
        return approvalRejectionStatus;
    }

    public void setApprovalRejectionStatus(String approvalRejectionStatus) {
        this.approvalRejectionStatus = approvalRejectionStatus;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(String attendanceType) {
        this.attendanceType = attendanceType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "StudentAttendanceRecord{" +
                "rollNumber=" + rollNumber +
                ", studentName='" + studentName + '\'' +
                ", attendanceDate=" + attendanceDate +
                ", attendanceType='" + attendanceType + '\'' +
                ", reason='" + reason + '\'' +
                ", approvalRejectionStatus='" + approvalRejectionStatus + '\'' +
                '}';
    }
}
