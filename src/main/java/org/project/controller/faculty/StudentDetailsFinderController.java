package org.project.controller.faculty;

import org.project.model.StudentAttendanceRecord;
import org.project.model.StudentRecord;
import org.project.service.ServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentDetailsFinderController {
    @Autowired
    private ServiceImple serviceImple;

    @GetMapping("faculty/studentDetail")
    String giveData(@RequestParam("username") String username, HttpServletRequest request) {
// find the details of the particular roll number
        StudentRecord studentRecord = serviceImple.studentData(username);
        // now fetch all the attendance & leaves with the help of roll number
        StudentAttendanceRecord studentAttendanceRecord = serviceImple.getStudentDetailsUsingUsername(studentRecord.getRollNumber());
        System.out.println(studentAttendanceRecord);
        return "student/particularStudentData";
    }
}
