<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<head>

<title>Home Page</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<!-- Libraries CSS Files -->
<link href="resources/indexCss/font-awesome.min.css" rel="stylesheet">
<link href="resources/indexCss/animate.min.css" rel="stylesheet">
<link href="resources/indexCss/ionicons.min.css" rel="stylesheet">
<link href="resources/indexCss/owl.carousel.min.css" rel="stylesheet">
<link href="resources/indexCss/lightbox.min.css" rel="stylesheet">
<link href="resources/indexCss/creative.min.css" rel="stylesheet">


<!-- Main Stylesheet File -->
<link href="resources/indexCss/style.css" rel="stylesheet">

<style>
body {
	font: 400 15px/1.8 Lato, sans-serif;
	color: #777;
}

.container {
	padding: 80px 120px;
}

.navbar {
	font-family: Montserrat, sans-serif;
	margin-bottom: 0;
	background-color: #2d2d30;
	border: 0;
	/* font-size: 11px !important; */
	letter-spacing: 4px;
	opacity: 0.9;
}

.navbar li a, .navbar .navbar-brand {
	color: #d5d5d5 !important;
}

.navbar-nav li a:hover {
	color: #fff !important;
}

.navbar-nav li.active a {
	color: #fff !important;
	background-color: #29292c !important;
}

.navbar-default .navbar-toggle {
	border-color: transparent;
}

.open .dropdown-toggle {
	color: #fff;
	background-color: #555 !important;
}

.dropdown-menu li a {
	color: #000 !important;
}

.dropdown-menu li a:hover {
	background-color: red !important;
}

footer {
	background-color: #2d2d30;
	color: #f5f5f5;
	padding: 32px;
}

footer a {
	color: #f5f5f5;
}

footer a:hover {
	color: #777;
	text-decoration: none;
}

.form-control {
	border-radius: 0;
}

textarea {
	resize: none;
}

.btn.btn-signin {
	background-color: rgb(104, 145, 162);
	padding: 0px;
	font-weight: 700;
	font-size: 14px;
	height: 36px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;
	border: none;
}

		.bodys1 {
   			background: url( resources/img/bg4.jpg) no-repeat center center fixed;    			
    		background-color: rgba(0,0,0,0.1);
			background-blend-mode: overlay;
			color:#fff;
    		min-height:100%;
    		background-attachment: fixed;
    		background-repeat: no-repeat;
    		background-size: cover;
    		-moz-background-size: cover;
			} 
			 

</style>
</head>

<body class="bodys1">

				<br><br><br><br><br><br><br>

<div class="row justify-content-center mr-top">
					<div class="col-md-12 text-center">
						<img src="<c:url value="resources/img/customLogo.png"/>" class="img-fluid" title="Rays Technology"/>
					</div>
				</div>
				
				<br>
				
				<div class="row justify-content-center mr-top">
					<div class="col-md-12 text-center">
						<a href="<c:url value="/Welcome"/>" class="btn btn-lg btn-success text-center" style="border-radius:15px" title="Click Here" >
						Online Result System
						</a>
					</div>
				</div>

</body>
</html>

