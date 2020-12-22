<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<div class="container">
	<div class="card card-container" style="background-color:#e46f1d6e">
		<div align="center" style="font-style: italic; color: white">
			<h2 style="color: white">

				<font color="black"><b><s:message code="label.myProfile"></s:message>
				</b></font>

			</h2>
		</div>
		<br>
		<div class=alert-success align="center" style="font-size: 150%">
			<b class="success">${success}</b>
		</div>



		<div class="alert-danger" align="center" style="font-size: 150%">

			<b class="error">${error}</b>
		</div>
		<br>
		<sf:form method="POST" commandName="form">

			<sf:hidden path="id" />
		<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="login">
						<s:message code="user.label.login" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-envelope"></span>
						</div>
						<sf:input path="login" placeholder="Enter login Id"
							readonly="true" class="form-control" />
					</div>
					<sf:errors path="login" cssClass="error" />
					<br>
				</div>
			</div>

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
						<sf:input path="firstName" placeholder="Enter First Name"
							class="form-control" />
					</div>
					<sf:errors path="firstName" cssClass="error" />
					<br>
				</div>
			</div>

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
						<sf:input path="lastName" placeholder="Enter Last Name"
							class="form-control" />
					</div>
					<sf:errors path="lastName" cssClass="error" />
					<br>
				</div>
			</div>

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
						<sf:input path="dob" readonly="true" placeholder="Enter DOB"
							class="form-control" />
					</div>
					<sf:errors path="dob" cssClass="error" />
					<br>
				</div>
			</div>

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
						<sf:input path="mobileNo" placeholder="Enter Mobile no"
							class="form-control" />
					</div>
					<sf:errors path="mobileNo" cssClass="error" />
					<br>
				</div>
			</div>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="gender">
						<s:message code="user.label.gender" />
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
							<sf:option value="" label="Select" />
							<sf:option value="Female" label="Female" />
							<sf:option value="Male" label="Male" />
						</sf:select>
					</div>
					<sf:errors path="gender" cssClass="error" />
					<br>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-2">
					<button type="submit" class="btn btn-success" name="operation"
						value="Update">
						<span class="glyphicon glyphicon-ok-sign"></span>
						<s:message code="button.updaate"></s:message>

					</button>
				</div>

				<div class="col-sm-offset-1 col-sm-2">
					<button type="submit" class="btn btn-info" name="operation"
						value="Change Password">
						<span class="glyphicon glyphicon-edit"></span>
						<s:message code="button.changePassword"></s:message>
					</button>
				</div>
			</div>



		</sf:form>
	</div>
</div>
<script>
	$(function() {
		$("#dob").datepicker();
	});

	
</script>