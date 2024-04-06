package org.project.utilities;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;

public class ProjectUtils {

    public static User getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication){
            User loggedInUser = (User)authentication.getPrincipal();
            return loggedInUser;
        }
        return null;
    }
    public static LocalDate getCurrentSystemDate(){
        LocalDate currentSystemDate = LocalDate.now();
        return currentSystemDate;
    }

}
