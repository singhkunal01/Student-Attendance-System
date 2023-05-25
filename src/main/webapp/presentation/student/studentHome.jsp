<%@ page contentType="text/html" language= "java" %>
<%@ page import="org.project.model.StudentRecord" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title> ${studentLoggedIn} Details </title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500&&family=Nanum+Pen+Script&display=swap" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />


<style>
*{
margin:0;
padding:0;
box-sizing:border-box;
}
body{
background: #f8f8f8;
font-family:"Poppins";
}

h2{
font-size:3rem;
display: grid;
font-family:"Nanum Pen Script";
place-items: center;
text-transform:uppercase;
margin-bottom:20px;
}

.main-container{
display:grid;
grid-template-columns:1fr 6fr;
}
.first-section{
padding:10px 20px;
background-color:#2d2a2a;
height:100vh;
color:#fff;
}
.first-section{
>p{
padding:10px 20px;
}
>p a{
text-decoration:none;
color:#fff;
}
> p a:hover{
transition:.25s all ;
opacity:0.8;
font-weight:500;
}
}

.second-section{
margin:10px;
}

.studentData {
border-bottom : 1px solid #ececec;
border-top : 1px solid #ececec;

}

.studentData ul{
display: flex;
align-items:center;
justify-content : space-between;
flex-direction : row;
}
.studentData > ul li{
list-style : none;
margin : 10px 20px;
}

.functionalSection{
display: grid;
grid-template-columns:1fr 1fr;
place-items: center;
height : 80%;
}
.functionalSection > .functionalInformation{
    width : 60%;
    line-height:2rem;
}

.functionalSection .functionalInformation h3{
    margin-bottom: 10px;
    text-transform : uppercase;
    text-align:center;
}

.functionalSection .functionalInformation span{
    color : #e9501b;
    font-weight : 600;
}

.functionalSection .functionalButtons{
    display : flex;
    flex-direction : column;
}

.functionalSection .functionalButtons a{
  margin: 20px 35px;
  text-decoration : none;
  color : #fff;
  background-color : #a75027;
  padding : 20px 35px;
  border-radius : 5px 20px;
  text-align:center;
}

.functionalSection .functionalButtons a:hover{
  border-radius : 20px 5px;
  opacity : 0.9;
  transition : 0.4s all;
}

#copyright-text {
  font-size: 1rem;
  font-family: "Nanum Pen Script";
  text-align:center;
  position : absolute;
  left : 50%;
  bottom :0;
}



</style>
</head>
<body>
<% StudentRecord currentLoggedInStudentData = (StudentRecord)request.getAttribute("currentLoggedInStudentData");%>

<div class = "main-container">
    <div class = "first-section">
        <p class="icon"> <i class="fa-sharp fa-light fa-user"></i> Hi, &nbsp;${currentLoggedInStudentData.getStudentName()}  </p>
        <p class="icon fa-fade"> <i class="fa-sharp fa-arrow-right-from-bracket fa-beat"></i><a href="logout"> Logout </a></p>
        <p style = "color:#e0d684;"> <i class="fa-sharp fa-calendar-days"></i> ${currentBusinessDate}</p>
    </div>

    <div class = "second-section">
        <h2 class="">Apply For Attendance / Leaves</h2>
        <div class = "studentData">
            <ul>
                <li><strong>Roll Number :</strong>${currentLoggedInStudentData.getRollNumber()}</li>
                <li><strong>Course :</strong>${currentLoggedInStudentData.getCourse()}</li>
                <li><strong>Branch :</strong>${currentLoggedInStudentData.getBranch()}</li>
                <li><strong>Current Year :</strong>${currentLoggedInStudentData.getCurrentYear()}</li>
                <li><strong>Date Of Birth :</strong>${currentLoggedInStudentData.getDateOfBirth()}</li>
            </ul>
        </div>
        <div class = "functionalSection">
            <div class = "functionalInformation">
             <h3>Information</h3>
             <p>
             Hello <span>${currentLoggedInStudentData.getStudentName()}</span>, Welcome to your Attendance and Leave Page! This platform empowers you to track your attendance records,apply for attendance, apply for leaves, and manage your academic schedule efficiently.
             </p>
            <p> - Future Institute </p>
            </div>
            <div class = "functionalButtons">
               <a href = "student/applyAttendance?username=${currentLoggedInStudentData.getStudentUsername()}">Apply Attendance</a>
               <a href = "student/applyLeave?username=${currentLoggedInStudentData.getStudentUsername()}">Apply Leave</a>
            </div>
        </div>
        <p id = "copyright-text"> &copy;Kunal Singh </p>
     </div>
</div>
</body>
</html>