<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page errorPage="Error.jsp" %>

<%@ page isELIgnored="false"%>
<html>
<head>

</head>
<body>
<div class="container" >
		<div class="card card-container" style="max-width: 455px;background-color:#e46f1d6e" >

<sf:form method="POST" commandName="form" >
<div align="center" style="font-style: italic;color:white">
					<h2 style="color:white ">
						
						<font color="black"><b><s:message code="label.forgetYourPassword"/> </b></font>
					
					</h2>
					<h4 style="color:black; ">
						
						<b><s:message code="label.message"/> </b>
					
					</h4>
				</div>
				<br>
  <div class=alert-success align="center"
						style="  font-size: 150%">
					<b>${success}</b>
				</div>
				


					<div class="alert-danger"align="center" style="  font-size: 150%">

						<b>${error}</b>
					</div>
	<br>
	<s:message code="login.placholder.email" var="email"></s:message>
	
	<sf:label path="login">
                    <s:message code="label.emailId" />
                </sf:label>
                
	<div class="input-group">
	
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-envelope"></span>
					</div>
					<sf:input path="login" class="form-control" placeholder="${email}"/>
				</div>
				<sf:errors path="login" cssClass="error" />
				<br>
  
  
<table style="margin-left: 50px">
	<tr>
				<th></th>
				<td><button type="submit" name="operation" class="btn btn-success" 
					value="Go"><span class="glyphicon glyphicon-ok-sign"></span> <s:message code="button.go" /> </button> &emsp; 
				<button type="submit" name="operation" class="btn btn-info"
					value="Reset"><span class="glyphicon glyphicon-refresh"></span> <s:message code="button.reset"/> </button> </td>
			</tr>
	
	</table>
</sf:form>
</div></div>
</body></html>