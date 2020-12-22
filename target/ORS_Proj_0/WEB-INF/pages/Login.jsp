
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<!-- <body style="background-image: url('http://localhost:8080/ORS_Proj_0/resources/images/Back.jpg')">
 -->
<body style="background-image: url('<c:url value="http://localhost:8080/ORS_Proj_0/resources/Back4.jpg" />');">

	<sf:form method="post" commandName="form">
		<div class="container">

			<%--card color #009900 <div class="card card-container"
				style="max-width: 500px;background-image: url('<c:url value="http://localhost:8080/ORS_Proj_0/resources/Back4.jpg" />');"> --%>
		<div class="card card-container" style="max-width: 500px;background-color:#e46f1d6e">
				<div align="center" style="font-style: italic; color: black;">
					<h3 style="color:black;">

						<b><s:message code="label.login.account"></s:message> </b>
     
					</h3>
				</div>
				<br>
				<div class=alert-success align="center" style="font-size: 150%">
					<b class="success">${success}</b>
				</div>

				<c:if test="${!empty message}">
					<div class="alert-danger"
						style="font-size: 150%; background-color: transparent;">
						<b class="error"><s:message code="frontcontroller.message"></s:message>
						</b>
					</div>
				</c:if>



				<div class="alert-danger"
					style="font-size: 150%; background-color: transparent;">

					<b class="error">${error}</b>
				</div>
				
				 <%-- <sf:hidden path="uri" value="${uri}"/> --%>
				<s:message code="login.placholder.email" var="email"></s:message>
				<div style="color: black;">
					<sf:label path="emailId">
						<s:message code="label.emailId" />
					</sf:label>

				</div>
				<div class="input-group">

					<div class="input-group-addon">
						<span class="fa fa-envelope" style="color: #1990EE;"></span>
					</div>
					<sf:input path="emailId" class="form-control"
						placeholder="${email}"/>

				</div>
				<sf:errors path="emailId" cssClass="error" />
				<br>
				
				
				<div style="color: black;">
					<sf:label path="password">
						<s:message code="label.password" />
					</sf:label>
				</div>
				<div class="input-group">
					<s:message code="label.password" var="password"></s:message>
					<div class="input-group-addon">
						<span class="fa fa-key" style="color: #1990EE;"></span>
					</div>
					<sf:password path="password" class="form-control"
						placeholder="${password}"/>

				</div>
				<sf:errors path="password" cssClass="error" />
				<br>
				
				
				<button type="submit" name="operation" class="btn btn-primary" style="width: 100%" value="SignIn">
					<s:message code="login.lebel.signIn"></s:message>
				</button>

				&nbsp; &nbsp;&nbsp; <br> 
				<a style="color: black;" href='<c:url value="/ForgetPassword"/>' class="forgot-password">
				<s:message code="login.lebel.forgetMyPassword"></s:message> </a>&nbsp;|&nbsp;
				<a style="color: black;" href='<c:url value="/SignUp" />'
					class="forgot-password"><s:message
						code="login.lebel.userRegistration"></s:message> </a>

			</div>	
		</div>
	</sf:form>
</body>