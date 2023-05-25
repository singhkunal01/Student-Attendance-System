package org.project.controller.faculty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentDetailsFinderController {
    @GetMapping("faculty/studentDetail")
    String giveData(@RequestParam("rollNumber") String rollNumber, HttpServletRequest request){
        System.out.println("roll number controller");
// find the details of the particular roll number
        request.setAttribute("rollNumber",rollNumber);
        return "student/particularStudentData";
    }
}
