
<meta charset="utf-8">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>">
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<%-- 
	<link rel="stylesheet" href='<c:url value="/resources/js/jquery-1.12.4.js" ></c:url>'>
<script src="<c:url value="/resources/js/jquery-ui.js" ></c:url>"></script>
<script src="<c:url value="/resources/js/jquery-ui.css" ></c:url>"></script>
 --%>
 <script>
	var date = new Date();
	var first = date.getFullYear() - 60;
	var last = date.getFullYear() - 20;
	$(function() {
		$("#dob").datepicker({
			changeMonth : true,
			changeYear : true,
			changeDay : true,
			yearRange : "-50:-18",
			maxDate : 0,

		});
	});
	var dateToday = new Date();
	$(function() {
		$("#datepicker1").datepicker({
			changeMonth : true,
			changeYear : true,
			changeDay : true,
			showWeekNumbers : true,
			showMonthAfterYear : true,
			minDate : +1,
			yearRange : "20",

			dateFormat : "mm/dd/yy",

		});
	});
</script>

<head>
<script>
function selectAll(source) {

	checkboxes = document.getElementsByName('ids');
	//alert(checkboxes);
	for (var i = 0, n = checkboxes.length; i < n; i++) {
		checkboxes[i].checked = source.checked;

	}
}

$(document).ready(function() {
	$('[name="ids"]').click(function() {
		if (!($(this)[0].checked)) {
			$('[onclick="selectAll(this)"]')[0].checked = false;
		}
		;
	});

	/* $('[onclick="selectAll(this)"]').click(function(){
		alert("hi")
	}); */
});
</script>
<style type="text/css">

th {
	font-size: 15px;
}

.card-container.card {
	max-width: 600px;
	padding: 40px 40px;
}

/*
 * Card component
 */
.card {
/* /* background-color: black; */
	
	padding: 20px 25px 30px;
	margin: 0 auto 15px;
	

	 -moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px; 
	 /* -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3); 
 */}



.btn.btn-signin:hover, .btn.btn-signin:active, .btn.btn-signin:focus {
	/* background-color: rgb(12, 97, 33); */
	
}

#nav a {
	text-decoration: none;
	font-size: 24px;
	font-style: normal;
	font-weight: normal;
	text-transform: normal;
	letter-spacing: normal;
	color: #596365;
}

#nav a:hover {
	text-decoration: none;
	color:blue;
}
body {
	background-repeat: no-repeat;
	background-size: cover;
	<%-- /* The image used */
	background-image: url("<%=ORSView.APP_CONTEXT%>/img1/5.png");
	background-size: 100% 200%; --%>
}

</style>

</head>
 <body style="background-image: url('<c:url value="http://localhost:8080/ORS_Proj_0/resources/img/new3.jpg" />');"> 
<!-- <body background-color:White> -->
 <nav class="navbar navbar-default ">
		<div class="container-fluid" style="background-color: black;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<%-- <a class="navbar-brand" href=""> <img alt=""
					src="<%=ORSView.APP_CONTEXT%>/img/customLogo.jpg"
					style="width: 96px; height: 35px">
				</a> --%>
				<a class="navbar-brand" href="<c:url value="/Welcome" />"><font
					style="color: red; font-size: 45px">R</font><font
					style="color: white;">AYS</font></a>

			</div>
			<div class="collapse navbar-collapse" id="myNavbar"
				style="background-color: black;">
				<ul class="nav navbar-nav navbar-right">


					<c:if test="${empty sessionScope.user}">
						<li><a href='<c:url value="/SignUp" />'><b
								style="color: white;"><s:message code="header.userRegistration"></s:message>  </b><span
								style="color: white;" class="fa fa-user-plus"></span></a></li>
						<li><a href="<c:url value="/Login" />"><b
								style="color: white;"> <s:message code="header.login"></s:message></b><span style="color: white;"
								class="  glyphicon glyphicon-log-in"></span></a></li>
					</c:if>
				</ul>
				<ul class="nav navbar-nav navbar-left">
					<c:if test="${not empty sessionScope.user}">
						<c:if test="${sessionScope.user.roleId == 1}">
							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp; &nbsp; <s:message code="header.user"></s:message> <span
									class="caret"></span>
							</a>
								<ul class="dropdown-menu" style="">
									<li><a href="<c:url value="/ctl/User" />"><span
											class="fa fa-user-plus"
											style="font-size: 16px; ;"></span>&nbsp; <font
											><s:message code="header.addUser"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/User/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font style=""><s:message code="header.userList"></s:message></font></a></li>

								</ul></li>

							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp; &nbsp; <s:message code="header.college"></s:message>
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
									<li><a href="<c:url value="/ctl/College" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 16px;"></span>&nbsp; <font
											><s:message code="header.addCollege"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/College/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.collegeList"></s:message></font></a></li>

								</ul></li>

							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp; &nbsp; <s:message code="header.student"></s:message>
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
									<li><a href="<c:url value="/ctl/Student" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 16px; "></span>&nbsp; <font
											><s:message code="header.addStudent"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/Student/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.studentList"></s:message></font></a></li>

								</ul></li>
							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp;  <s:message code="header.course"></s:message>
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
									<li><a href="<c:url value="/ctl/Course" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 16px; "></span>&nbsp; <font
											><s:message code="header.addCourse"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/Course/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.courseList"></s:message></font></a></li>

								</ul></li>
							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp; &nbsp; <s:message code="header.subject"></s:message>
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="<c:url value="/ctl/Subject" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 16px; "></span>&nbsp; <font
											><s:message code="header.addSubject"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/Subject/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.subjectList"></s:message></font></a></li>

								</ul></li>

							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp;  <s:message code="header.role"></s:message> <span
									class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
									<li><a href="<c:url value="/ctl/Role" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 15px; "></span>&nbsp; <font
											><s:message code="header.addRole"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/Role/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.roleList"></s:message></font></a></li>

								</ul></li>

							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp; &nbsp; <s:message code="header.timetable"></s:message>
									 <span class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
									<li><a href="<c:url value="/ctl/TimeTable" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 15px; "></span>&nbsp; <font
											><s:message code="header.addTimetable"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/TimeTable/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.timetableList"></s:message></font></a></li>

								</ul></li>
							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp;  <s:message code="header.faculty"></s:message>
									<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
									<li><a href="<c:url value="/ctl/Faculty" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 16px; "></span>&nbsp; <font
											><s:message code="header.addFaculty"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/Faculty/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.facultyList"></s:message></font></a></li>

								</ul></li>
							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp; 
									<s:message code="header.marksheet"></s:message> <span class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
									<li><a href="<c:url value="/ctl/Marksheet" />"><span
											class="glyphicon glyphicon-plus"
											style="font-size: 16px; "></span>&nbsp; <font
											><s:message code="header.addMarksheet"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/Marksheet/search" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.marksheetList"></s:message></font></a></li>
											
											<li><a href="<c:url value="/ctl/Marksheet/meritlist" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.marksheetMeritList"></s:message></font></a></li>
											
											<li><a href="<c:url value="/ctl/Marksheet/get" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.getMarksheet"></s:message></font></a></li>

								</ul></li>
							<li class="dropdown"><a
								style="color: white; background-color: black;"
								data-toggle="dropdown" href="#"> &nbsp;  <s:message code="header.hii"></s:message> <c:out
										value="${sessionScope.user.firstName}" /> <span class="caret"></span>
							</a>
								<ul class="dropdown-menu" >
								 <li><a ><span
											class="glyphicon glyphicon-user"
											style="font-size: 16px; "></span>&nbsp; <font
											><c:out value="${sessionScope.role.roleName}"></c:out> </font></a></li>
								 
									<li><a href="<c:url value="/ctl/User/profile" />"><span
											class="glyphicon glyphicon-edit"
											style="font-size: 16px; "></span>&nbsp; <font
											><s:message code="header.myProfile"></s:message></font></a></li>
									<li><a href="<c:url value="/ctl/User/changepassword" />"><span
											class="glyphicon glyphicon-cog" ></span>&nbsp;
											<font ><s:message code="header.changePassword"></s:message></font></a></li>
											
											<li><a target="blank" href="<c:url value="/resources/doc/index.html" />"><span
											class="glyphicon glyphicon-list" ></span>&nbsp;
											<font ><s:message code="header.javadoc"></s:message></font></a></li>
											
											<li><a href="<c:url value="/Login" />"><span
											class="glyphicon glyphicon-log-out" ></span>&nbsp;
											<font ><s:message code="header.logout"></s:message></font></a></li>

								</ul></li>
						</c:if>
					</c:if>
				</ul>

			</div>


		</div>
	</nav>

	<table width=100%>
		
		<tr>
			<td colspan="2"  style="text-align: left;">
			 <a class="btn btn-warning" href="?lang=en"><font color="black">English</font></a>  
			 <a class="btn btn-warning" href="?lang=hi"><font color="black"><s:message code="lable.hindi"></s:message></font> </a>
				
			</td>
		</tr>
		
	</table>
</body>