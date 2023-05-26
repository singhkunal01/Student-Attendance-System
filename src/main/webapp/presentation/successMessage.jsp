

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Record Status</title>
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <meta name="description" content="" />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500&&family=Nanum+Pen+Script&display=swap" rel="stylesheet"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

  <style>
  *{
  margin:0;
  padding:0;

  }
  h1{
  opacity:0.8;
  font-size:5rem;
  text-align:center;
  font-family: "Nanum Pen Script";
  }
  #copyright-text {
    font-size: 1rem;
    font-family: "Nanum Pen Script";
    text-align:center;
    position : absolute;
    left : 50%;
    bottom :0;
  }
  p a{
  text-decoration:none;
  font-size:1.5rem;
  color:seagreen;
  font-family:'Poppins';
  }
  </style>
</head>
<body>
<h1>${messageConfirmation}<h1>
<p class="icon fa-fade"><a href="${pageContext.request.contextPath}/loginPage"> Home </a></p>

<p id = "copyright-text"> &copy;Kunal Singh </p>

</body>
</html>