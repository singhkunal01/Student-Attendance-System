package org.project.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.project.model.StudentRecord;
import org.project.service.ServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class LoginController {
    Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private ServiceImple service;

    // here during loginPage mapping the role will be checked whether the person is FACULTY or STUDENT
    @GetMapping("/loginPage")
    String performLoginOnTheBasisOfRole(ModelMap mp) {

// if user is faculty then show the data of all students with some columns
        LocalDate currentBusinessDate = LocalDate.now();
        mp.addAttribute("currentBusinessDate", currentBusinessDate);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().stream().anyMatch(role -> role.getAuthority().equals("FACULTY"))) {
//            logger.info(auth.getName() + "Logged In");

            List<StudentRecord> allStudents = service.getAllStudentsDetails();
            mp.addAttribute("currentuser", auth.getName());

            mp.addAttribute("listOfAllStudents", allStudents);

            return "faculty/facultyHome";
        }
        // find the name of student who logged In on the basis of username
        StudentRecord studentRecord = service.studentData(auth.getName());
        mp.addAttribute("currentLoggedInStudentData", studentRecord);
        return "student/studentHome";

    }


}
