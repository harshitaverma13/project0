<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>

<div class="container">
<div class="card card-container" style="background-color:#e46f1d6e">
	<%-- <div class="card card-container"style="max-width: 500px;background-image: 
	url('<c:url value="http://localhost:8080/ORS_Proj_0/resources/Back4.jpg" />');"> --%>
		<div align="center" style="font-style: italic; color: white">
			<h2 style="color: white">
				<font color="black"><b><s:message
							code="user.label.userRegistration"></s:message> </b></font>
			</h2>
		</div>
		<br>
		<div class=alert-success align="center" style="font-size: 150%">
			<b class="success">${success}</b>
		</div>



		<div class="alert-danger" align="center" style="font-size: 150%">

			<b class="error">${error}</b>
		</div>
		<sf:form method="POST" commandName="form">
                 <sf:hidden path="id" />
	
			
						<br>
						<s:message code="user.placeholder.firstName" var="firstName"></s:message>
						
			<div class="form_group row">
				<div class="col-sm-4">
				
			<sf:label path="firstName">
				<s:message code="user.label.firstName" />
			</sf:label>
			<font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</div>
				<sf:input path="firstName" placeholder="${firstName }" class="form-control" />
			</div><sf:errors path="firstName" cssClass="error" /><br></div></div>
			
			
        <s:message code="user.placeholder.lastName" var="lastName"></s:message>
			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="lastName">
				<s:message code="user.label.lastName" />
			</sf:label>
			<font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</div>
				<sf:input path="lastName" placeholder="${lastName }"
					class="form-control" />
			</div><sf:errors path="lastName" cssClass="error" /><br> </div></div>
			
			
          <s:message code="user.placeholder.login" var="login"></s:message>
			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="emailId">
				<s:message code="user.label.login" />
			</sf:label>
			<font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-envelope"></span>
				</div>
				<sf:input path="emailId" placeholder="${login }"
					class="form-control" />
			</div><sf:errors path="emailId" cssClass="error" /><br></div></div>
			
			
			
       <s:message code="user.placeholder.password" var="password"></s:message>
			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="password">
				<s:message code="user.label.password" />
			</sf:label>
			<font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</div>
				<sf:password path="password" placeholder="${password }"
					class="form-control" />
			</div><sf:errors path="password" cssClass="error" /><br></div></div>
			
			
			
			<s:message code="user.placeholder.confirmPassword" var="confirmPassword"></s:message>			
			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="confirmPassword">
				<s:message code="user.label.confirmPassword" />
			</sf:label>
			<font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-lock"></span>
				</div>
				<sf:password path="confirmPassword" placeholder="${confirmPassword }"
					class="form-control" />
			</div><sf:errors path="confirmPassword" cssClass="error" /><br></div></div>
			
<s:message code="user.placeholder.dob" var="dob"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="dob">
				<s:message code="user.label.dob" />
			</sf:label>
			<font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-calendar"></span>
				</div>
				<sf:input path="dob" readonly="true" placeholder="${dob }" class="form-control" />
			</div><sf:errors path="dob" cssClass="error" /><br></div></div>
			
			
			
<s:message code="user.placeholder.mobileNo" var="mobileNo"></s:message>
			<div class="form_group row">
				<div class="col-sm-4">
			       <sf:label path="mobileNo">
				      <s:message code="user.label.mobileNo" />
			      </sf:label>
			        <font color="red">*</font>
			  </div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-phone"></span>
				</div>
				<sf:input path="mobileNo" placeholder="${mobileNo }"
					class="form-control" />
			</div><sf:errors path="mobileNo" cssClass="error" /><br></div></div>
			
			
			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="gender">
				<s:message code="user.label.gender" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="fa fa-transgender"></span>
				</div>
				<sf:select STYLE="width: 100%" size="0" path="gender"
					class="form-control">
					<sf:option value="" label="Select" >
							------------------<s:message code="label.select"></s:message>------------------
							</sf:option>
							
							<sf:option value="Female" >
							<s:message code="label.female" />
							</sf:option>
							<sf:option value="Male" >
							<s:message code="label.male" />
							
							</sf:option>
				</sf:select>
			</div><sf:errors path="gender" cssClass="error" /><br></div></div>

			

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<button type="submit" class="btn btn-success" name="operation"
								value="Save">
								<span class="glyphicon glyphicon-ok-sign"></span> <s:message code="op.save"></s:message>
					</button>
				</div>

				<div class="col-sm-offset-2 col-sm-2">
					<button type="submit" class="btn btn-info" name="operation"
								value="Reset">
								<span class="glyphicon glyphicon-refresh"></span> <s:message code="op.reset"></s:message>
							</button>	
				</div>
			</div>

		</sf:form>
</div></div>

		<script>
			$(function() {
				$("#dob").datepicker();
			});
		
			
		</script>