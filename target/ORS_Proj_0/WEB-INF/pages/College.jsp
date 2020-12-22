<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>


<div class="container">
	<div class="card card-container" style="background-color:#e46f1d6e">
		<div align="center" style="font-style: italic; color: white">
			<h2 style="color: white">
				<c:choose>

					<c:when test="${form.id>0}">
						<font color="black"><b><s:message
									code="college.label.updateCollege"></s:message> </b></font>
					</c:when>
					<c:otherwise>
						<font color="black"><b><s:message
									code="college.label.addCollege"></s:message> </b></font>
					</c:otherwise>
				</c:choose>

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
			<sf:hidden path="createdBy" />
			<sf:hidden path="modifiedBy" />
			<sf:hidden path="createdDatetime" />
			<sf:hidden path="modifiedDatetime" />

			<br>
			<s:message code="college.placeholder.name" var="name"></s:message>
			<div class="form_group row">
				<div class="col-sm-3">
					<sf:label path="name">
						<s:message code="label.name" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="fa fa-institution" style="font-size: 13px"></span>
						</div>
						<sf:input path="name" placeholder="${name}"
							class="form-control" />
					</div>
					<sf:errors path="name" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="college.placeholder.address" var="address"></s:message>
	
			<div class="form_group row">
				<div class="col-sm-3">
					<sf:label path="address">
						<s:message code="label.address" />
					</sf:label>
					<font color="red">*</font>
				</div>

				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-map-marker"></span>
						</div>
						<sf:input path="address" placeholder="${address}"
							class="form-control" />
					</div>
					<sf:errors path="address" cssClass="error" />
					<br>
				</div>
			</div>

		
<s:message code="college.placeholder.state" var="state"></s:message>
	
			<div class="form_group row">
				<div class="col-sm-3">
					<sf:label path="state">
						<s:message code="label.state" />
					</sf:label>
					<font color="red">*</font>
				</div>

				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-globe"></span>
						</div>
						<sf:input path="state" placeholder="${state}"
							class="form-control" />
					</div>
					<sf:errors path="state" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="college.placeholder.city" var="city"></s:message>
	

			<div class="form_group row">
				<div class="col-sm-3">
					<sf:label path="city">
						<s:message code="label.city" />
					</sf:label>
					<font color="red">*</font>
				</div>

				<div class="col-sm-8">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="fa fa-building"></span>
						</div>
						<sf:input path="city" placeholder="${city}"
							class="form-control" />
					</div>
					<sf:errors path="city" cssClass="error" />
					<br>
				</div>
			</div>

<s:message code="college.placeholder.phone" var="phone"></s:message>
	
			<div class="form_group row">
				<div class="col-sm-3">
					<sf:label path="phoneNo">
						<s:message code="label.phoneNo" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-phone"></span>
						</div>
						<sf:input path="phoneNo" placeholder="${phone}"
							class="form-control" />
					</div>
					<sf:errors path="phoneNo" cssClass="error" />
					<br>
				</div>
			</div>

				<div class="form-group">
				<div class="col-sm-offset-3 col-sm-2">
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