package org.project.controller.student;

import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecord;
import org.project.model.customUtils.DateConverter;
import org.project.service.ServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
public class ApplyAttendanceLeaveController {
    @Autowired
    private ServiceImple serviceImple;

    //    init binder for the customise data format
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new DateConverter());
    }

    // ---------------------------------if student clicks on attendance---------------------------------
    @GetMapping("student/applyAttendance")
    String applyAttendance(HttpSession session, ModelMap mp) {
        StudentRecord studentRecord = (StudentRecord) session.getAttribute("currentLoggedInStudentData");
        mp.addAttribute("studentAttendanceRecord", new StudentAttendanceRecord());
        LocalDate currentBusinessDate = LocalDate.now();
        mp.addAttribute("currentBusinessDate", currentBusinessDate);

        return "student/applyAttendancePage";
    }

    // student applied the attendance
    @PostMapping("student/applyAttendance")
    String attendanceAppliedSuccessfully(HttpSession session, StudentAttendanceRecord studentAttendanceRecord, Model model) {
        // insert the attendance into dB
        StudentRecord studentRecord = (StudentRecord) session.getAttribute("currentLoggedInStudentData");

        studentAttendanceRecord.setStudentName(studentRecord.getStudentName());
        studentAttendanceRecord.setRollNumber(studentRecord.getRollNumber());
        studentAttendanceRecord.setReason("No Reason required in Attendance !!");
        studentAttendanceRecord.setAttendanceType("Present");
        studentAttendanceRecord.setApprovalRejectionStatus("Pending");

        Long rollNumber = studentRecord.getRollNumber();
        LocalDate attendanceDate = studentAttendanceRecord.getAttendanceDate();
        String attendanceType = studentAttendanceRecord.getAttendanceType();

        // insert the data only if the student not applied the attendance of same day
        if (ChronoUnit.DAYS.between(attendanceDate, LocalDate.now()) < 0) {
            model.addAttribute("message", "Date Must Be smaller or same as the current business date !");

        } else if (serviceImple.checkValidityForApplying(rollNumber, attendanceDate)) {
            serviceImple.attendanceAppliedInsertion(studentAttendanceRecord);
            model.addAttribute("message", "Applied Successfully");
        } else model.addAttribute("message", "Already Applied !");
        return "redirect:applyAttendance";
    }


    // --------------------------------- if student clicks on leave ---------------------------------
    @GetMapping("student/applyLeave")
    String applyLeave(HttpSession session, ModelMap mp) {
        StudentRecord studentRecord = (StudentRecord) session.getAttribute("currentLoggedInStudentData");
        mp.addAttribute("studentAttendanceRecord", new StudentAttendanceRecord());
        LocalDate currentBusinessDate = LocalDate.now();
        mp.addAttribute("currentBusinessDate", currentBusinessDate);

        return "student/applyLeavePage";
    }


    // student applied the leave
    @PostMapping("student/applyLeave")
    String leaveAppliedSuccessfully(HttpSession session, StudentAttendanceRecord studentAttendanceRecord, Model model) {
        // insert the leave into dB
        StudentRecord studentRecord = (StudentRecord) session.getAttribute("currentLoggedInStudentData");

        studentAttendanceRecord.setStudentName(studentRecord.getStudentName());
        studentAttendanceRecord.setRollNumber(studentRecord.getRollNumber());
        studentAttendanceRecord.setAttendanceType("Leave");
        studentAttendanceRecord.setApprovalRejectionStatus("Pending");

        Long rollNumber = studentRecord.getRollNumber();
        LocalDate attendanceDate = studentAttendanceRecord.getAttendanceDate();
        String attendanceType = studentAttendanceRecord.getAttendanceType();

        // insert the data only if the student not applied the attendance of same day and the date must not be greater than current business date
        if (ChronoUnit.DAYS.between(attendanceDate, LocalDate.now()) < 0) {
            model.addAttribute("message", "Date Must Be smaller or same as the current business date !");

        } else if (serviceImple.checkValidityForApplying(rollNumber, attendanceDate)) {
            serviceImple.leaveAppliedInsertion(studentAttendanceRecord);
            model.addAttribute("message", "Applied Successfully");
        } else model.addAttribute("message", "Already Applied !");
        return "redirect:applyLeave";
    }
}
