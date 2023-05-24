<%@ page contentType="text/html" language= "java" %>
<%@ page import="org.project.model.StudentRecord" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title> Student Details </title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500&&family=Nanum+Pen+Script&display=swap" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<%-- links for the jQuery dataTable--%>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.2/css/jquery.dataTables.css">
<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.js"></script>

<%-- links for the jQuery dataTable style --%>
<script src = "https://code.jquery.com/jquery-3.5.1.js"></script>
<script src = "https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
<script src = "https://cdn.datatables.net/1.13.4/js/dataTables.jqueryui.min.js"></script>

<%-- links for the jQuery dataTable style --%>
<link rel ="stylesheet" href ="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel ="stylesheet" href ="https://cdn.datatables.net/1.13.4/css/dataTables.jqueryui.min.css">

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
.icon{
display:flex;
align-items:center;
}
.fa-user,.fa-arrow-right-from-bracket{
font-size:1.7rem;
margin-right:10px;
}
.second-section #tableData{
margin:30px 40px;
}

#studentsRecords td a{
text-decoration:none;
color:#e07e10f0;
font-weight:500;
border-bottom : 2px solid;
}
</style>
</head>
<body>


<% java.util.ArrayList studentDetails = new java.util.ArrayList();
studentDetails = (java.util.ArrayList) request.getAttribute("listOfAllStudents");%>
<header>
</header>
<div class = "main-container">
<div class = "first-section">
<p class="icon"> <i class="fa-sharp fa-light fa-user"></i> ${currentuser}  </p>
<p class="icon fa-fade"> <i class="fa-sharp fa-arrow-right-from-bracket fa-beat"></i><a href="logout"> Logout </a></p>
</div>

<div class = "second-section">
<h2 class="">All Student Records</h2>
<div id = "tableData">
<table id = "studentsRecords" class="display">
<thead>
        <tr>
            <th>Username</th>
            <th>Name</th>
            <th>Roll Number</th>
        </tr>
    </thead>
    <tbody>
<c:forEach items="${listOfAllStudents}" var="value">

        <tr>
            <td>${value.getStudentUsername()}</td>
            <td>${value.getStudentName()}</td>
            <td><i class="fa-solid fa-arrow-right fa-beat-fade"></i><a href = "faculty/studentDetail?rollNumber=${value.getRollNumber()}"> ${value.getRollNumber()}</a></td>
        </tr>
</c:forEach>

    </tbody>
</table>
</div>
 </div>
</div>
<script>
      $(document).ready(function () {
        $("#studentsRecords").DataTable({
           scrollY:true,
        });
      });
</script>
</body>
</html>

<%--
            <th>Course</th>
            <th>Branch</th>
            <th>Current Year</th>
            <th>Date Of Birth</th>

            <td>${value.getCourse()}</td>
            <td>${value.getBranch()}</td>
            <td>${value.getCurrentYear()}</td>
            <td>${value.getDateOfBirth()}</td>
to style the dataTable add these classes in table :- stripe cell-border row-border hover order-column
--%>