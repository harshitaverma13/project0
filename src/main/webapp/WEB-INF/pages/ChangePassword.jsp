<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<div class="container">
		<div class="card card-container" style="background-color:#e46f1d6e">
		
<sf:form method="POST" commandName="form">

<div align="center" style="font-style: italic;color:white">
					<h2 style="color:white ">
						
						<font color="black"><b><s:message code="changepassword.leble"></s:message></b></font>
					
					</h2>
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
			<div class="form_group row">
				<div class="col-sm-4">	
			<s:message code="label.oldPassword" var="oldPassword" />
			
			<sf:label path="oldPassword">
				<s:message code="label.oldPassword" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</div>
				<sf:password path="oldPassword" placeholder="${oldPassword}"
					class="form-control" />
			</div>
			<sf:errors path="oldPassword" cssClass="error" /><br></div></div>
			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="newPassword">
				<s:message code="label.newPassword" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			<s:message code="label.newPassword" var="newPassword" />
		
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</div>
				<sf:password path="newPassword" placeholder="${newPassword }"
					class="form-control" />
			</div><sf:errors path="newPassword" cssClass="error" /><br></div></div>
			<s:message code="label.confirmPassword" var="confirmPassword" />
			
			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="confirmPassword">
				<s:message code="label.confirmPassword" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</div>
			 	<sf:password path="confirmPassword" placeholder="${confirmPassword}"
					class="form-control" />
			</div><sf:errors path="confirmPassword" cssClass="error" /><br></div></div>
			
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<button type="submit" class="btn btn-success" name="operation"
								value="Save">
								<span class="glyphicon glyphicon-ok-sign"></span>
								<s:message code="op.save"></s:message>

							</button>
				</div>

				<div class="col-sm-offset-1 col-sm-2">
					<button type="submit" class="btn btn-info" name="operation"
								value="Change my profile">
								<span class="glyphicon glyphicon-edit"></span>
								<s:message code="button.changeMyProfile"></s:message>
							</button>
				</div>
			</div>
   

</sf:form></div></div>