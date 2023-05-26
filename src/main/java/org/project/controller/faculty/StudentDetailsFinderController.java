package org.project.controller.faculty;

import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecord;
import org.project.model.customUtils.DateConverter;
import org.project.service.ServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class StudentDetailsFinderController {
    //    init binder for the customise data format
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new DateConverter());
    }

    @Autowired
    private ServiceImple serviceImple;

    @GetMapping("faculty/studentDetail")
    private String giveData(@RequestParam("username") String username, ModelMap mp, HttpServletRequest request) {
// find the details of the particular roll number
        StudentRecord studentRecord = serviceImple.studentData(username);
        mp.addAttribute("studentName", studentRecord.getStudentName());
        // now fetch all the attendance & leaves with the help of roll number
        List<StudentAttendanceRecord> studentAttendanceRecords = serviceImple.getStudentDetailsUsingRollNumber(studentRecord.getRollNumber());
        mp.addAttribute("currentStudentWholeRecord", studentAttendanceRecords);
        return "student/particularStudentData";
    }

    // when faculty approves the attendance or leave
    @GetMapping("faculty/studentDetail/approve")
    private String approveAttendanceLeave(@RequestParam("rollNumber") Long rollNumber, @RequestParam("dateOfAttendance") LocalDate dateOfAttendance, ModelMap mp) {
        serviceImple.updateStatusOfStudent(rollNumber,"Approved",dateOfAttendance);
        mp.addAttribute("messageConfirmation", "Record Approved");
        return "successMessage";
    }

    // when faculty rejects the attendance or leave
    @GetMapping("faculty/studentDetail/reject")
    private String rejectAttendanceLeave(@RequestParam("rollNumber") Long rollNumber,@RequestParam("dateOfAttendance")LocalDate  dateOfAttendance, ModelMap mp) {
        serviceImple.updateStatusOfStudent(rollNumber,"Rejected",dateOfAttendance);
        mp.addAttribute("messageConfirmation", "Record Rejected");
        return "successMessage";

    }
}
