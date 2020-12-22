 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<html>
<head>
<style type="text/css">
b{
color: black;
}

</style>
</head>

<div class="container" >
	<div class="card card-container"style="background-color:#e46f1d6e" >
		<div align="center" style="font-style: italic; color: black">
			<h2 >
				<c:choose>

					<c:when test="${form.id>0}">
						<font color="black"><b><s:message
									code="user.label.updateUser"></s:message> </b></font>
					</c:when>
					<c:otherwise>
						<font color="black"><b><s:message
									code="user.label.addUser"></s:message> </b></font>
					</c:otherwise>
				</c:choose>

			</h2>
		</div>
		<br>
		<div class="alert-success" align="center" style="font-size: 150%">
			<b class="success">${success}</b>
		</div>



		<div class="alert-danger" align="center" style="font-size: 150%">

			<b class="error">${error}</b>
		</div>
<br>
		<sf:form method="POST" commandName="form">

			<sf:hidden path="id" />
			<sf:hidden path="lastLogin"></sf:hidden>
			<sf:hidden path="registeredIP"></sf:hidden>
			<sf:hidden path="createdBy"></sf:hidden>
			<sf:hidden path="modifiedBy"></sf:hidden>
			<sf:hidden path="createdDatetime"></sf:hidden>
			<sf:hidden path="modifiedDatetime"></sf:hidden>

			

			<br>
<s:message code="user.placeholder.firstName" var="firstName"></s:message>
			<div class="form_group row">
				<div class="col-sm-4">
					<b> <sf:label path="firstName" >
							<s:message code="user.label.firstName" />
						</sf:label><font color="red">*</font></b>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</div>
						<sf:input path="firstName" placeholder="${firstName}"
							class="form-control" />
					</div>

					<sf:errors path="firstName" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="user.placeholder.lastName" var="lastName"></s:message>
			<div class="form_group row">
				<div class="col-sm-4">
					<b> <sf:label path="lastName">
							<s:message code="user.label.lastName" />
						</sf:label><font color="red">*</font></b>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</div>
						<sf:input path="lastName" placeholder="${lastName}"
							class="form-control" />
					</div>

					<sf:errors path="lastName" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="user.placeholder.login" var="login"></s:message>
			<div class="form_group row">
				<div class="col-sm-4">
					<b><sf:label path="login">
							<s:message code="user.label.login" />
						</sf:label><font color="red">*</font></b>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-envelope"></span>
						</div>
						<sf:input path="login" placeholder="${login}"
							class="form-control" />
					</div>

					<sf:errors path="login" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="user.placeholder.password" var="password"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
					<b><sf:label path="password">
							<s:message code="user.label.password" />
						</sf:label><font color="red">*</font></b>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-lock"></span>
						</div>
						<sf:password path="password" placeholder="${password }"
							class="form-control" />
					</div>
					<sf:errors path="password" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="user.placeholder.confirmPassword" var="confirmPassword"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="confirmPassword">
						<b><s:message code="user.label.confirmPassword" /></b>
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
					</div>
					<sf:errors path="confirmPassword" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="user.placeholder.dob" var="dob"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="dob">
						<b><s:message code="user.label.dob" /></b>
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</div>
						<sf:input path="dob" readonly="true" placeholder="${dob }"
							class="form-control" />
					</div>
					<sf:errors path="dob" cssClass="error" />
					<br>
				</div>
			</div>

<s:message code="user.placeholder.mobileNo" var="mobileNo"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="mobileNo">
						<b><s:message code="user.label.mobileNo" /></b>
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-phone"></span>
						</div>
						<sf:input path="mobileNo"  placeholder="${mobileNo}"
							class="form-control" />
					</div>
					<sf:errors path="mobileNo" cssClass="error" />
					<br>
				</div>
			</div>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="roleId">
						<b><s:message code="user.label.role" /></b>
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</div>
						<sf:select STYLE="width: 100%" size="0" path="roleId"
							class="form-control">
							<sf:option value="" label="Select">
							<s:message code="label.select"></s:message>
							</sf:option>
							<sf:options items="${roleList}" itemValue="id"
								itemLabel="roleName" />
								
						</sf:select>
					</div>
					<sf:errors path="roleId" cssClass="error" />
					<br>
				</div>
			</div>


			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="gender">
						<b><s:message code="user.label.gender" /></b>
					</sf:label>
					<font color="red">*</font>
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
							
							<%-- <sf:option value="nanu" >
							<s:message code="label.name" />
							</sf:option>
							 --%>
							
						</sf:select>
					</div>
					<sf:errors path="gender" cssClass="error" />
					<br>
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<c:choose>
						<c:when test="${form.id>0}">
							<button type="submit" class="btn btn-success" name="operation"
								value="Update">
								<span class="glyphicon glyphicon-ok-sign"></span>
								<s:message code="op.update"></s:message>
							</button>
						</c:when>
						<c:otherwise>

							<button type="submit" class="btn btn-success" name="operation"
								value="Save">
								<span class="glyphicon glyphicon-ok-sign"></span>
								<s:message code="op.save"></s:message>

							</button>
						</c:otherwise>
					</c:choose>
				</div>

				<div class="col-sm-offset-1 col-sm-2">
					<c:choose>
						<c:when test="${form.id>0}">

							<button type="submit" class="btn btn-warning" name="operation"
								value="Cancel">
								<span class="glyphicon glyphicon-remove-sign"></span>
								<s:message code="op.cancle"></s:message>
							</button>

						</c:when>
						<c:otherwise>
							<button type="submit" class="btn btn-info" name="operation"
								value="Reset">
								<span class="fa fa-refresh fa-spin"></span>
								<s:message code="op.reset"></s:message>
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</sf:form>
	</div>
</div>

</html>
 