<%@ page contentType="text/html" language= "java" %>
<html>
<head>
    <title> Home Page </title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500&&family=Nanum+Pen+Script&display=swap" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="shortcut icon" type="image/x-icon" href ="https://bit.ly/41By2h1">
    <style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  background-color: #ffffff;
  font-family: "Poppins";
  color: #2d2a2a;
}

h2 {
  width: 100%;
  font-size: 3rem;
  height: 55px;
  display: grid;
  top: 0;
  font-family: "Nanum Pen Script";
  margin: 20px 30px; /* Gives that scrolling effect as the typing happens */
  place-items: center;
  text-transform: uppercase;
}

.main-container {
  display: grid;
  grid-template-columns: 1.9fr 0.4fr 2.8fr;
}

.first-section {
  display: flex;
  padding: 30px;
  align-items: flex-start;
  flex-flow: column;
  justify-content: center;
  background-color: #2d2a2a;
  color: #ffff;
  height: 100vh;
}
.first-section li {
  line-height: 2.5rem;
}
.vertical-border {
  border-left: 2px dotted grey;
  height: 100vh;
  margin-left: 4px;
}

.second-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  flex-direction: column;
  padding-right: 40px;
}

img {
  width: auto;
  height: 400px;
  border: none;
  animation: MoveUpDown 2s infinite alternate;
}

@keyframes MoveUpDown {
  0% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
  }
  100% {
    -webkit-transform: translateY(-15px);
    transform: translateY(-15px);
  }
}

a {
  margin: 10px 5px;
  text-decoration: none;
  background-color: #2d2a2a;
  border-radius: 5px;
  color: #fbec55;
  font-weight: 500;
  padding: 15px 40px;
}

a:hover {
  opacity: 0.9;
  transition: 0.25s all;
}
p {
  text-align: center;
  font-size: 14px;
  color: grey;
}
span {
  color: #fbec55;
  font-family: consolas;
}
#copyright-text {
  font-size: 1rem;
  font-family: "Nanum Pen Script";
}


   </style>

</head>

<body>
<div class = "main-container">
    <div class="first-section">
        <li>This system is purely made for the <span > Future Institute of Engineering & Technology </span> for the Attendance & Leaves purpose
        </li>
        <li>Here Student Can apply For Attendance and Leaves.</li>
        <li>And Respective Faculty Can approve or reject attendance or leave.</li>
    </div>
    <div class="vertical-border"></div>
    <div class="second-section">
        <h2 class="">Student Attendance Management System</h2>
        <%--<img src ="${pageContext.request.contextPath}/presentation/images/college-img.jpg" alt = "college-photo"> --%>

        <img src="https://bit.ly/41By2h1" alt="college-img">

        <a href="loginPage" id="loginBtn"> Log In ? </a><br>
        <p id = "copyright-text"> &copy;Kunal Singh </p>
    </div>
</div>

<script>
//this will restrict the user to drag the image
const img = document.querySelector('img')
img.ondragstart = () => {
  return false;
};
</script>
</body>

</html>