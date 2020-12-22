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
									code="marksheet.label.updateMarksheet"></s:message> </b></font>
					</c:when>
					<c:otherwise>
						<font color="black"><b><s:message
									code="marksheet.label.addMarksheet"></s:message> </b></font>
					</c:otherwise>
				</c:choose>

			</h2>
		</div>
		<br>
		<div class=alert-success align="center" style="font-size: 150%;">
			<b >${success}</b>
			
		</div>
		<div class="alert-danger" align="center" style="font-size: 150%;">

			<b class="error">${error}</b>
			
		</div>
		<br>

		<sf:form method="POST" commandName="form">

			<sf:hidden path="id" />
			<sf:hidden path="createdBy" />
			<sf:hidden path="modifiedBy" />
			<sf:hidden path="createdDatetime" />
			<sf:hidden path="modifiedDatetime" />
			<s:message code="marksheet.placeholder.rollNo" var="rollNo"></s:message>
			
			<div class="form_group row">
				<div class="col-sm-4">
			
			<sf:label path="rollNo">
				<s:message code="label.rollNo" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-tag"></span>
				</div>
				<c:choose>
					<c:when test="${form.id>0}">
						<sf:input path="rollNo" placeholder="${rollNo}  "
							readonly="true" class="form-control" />
					</c:when>
					<c:otherwise>
						<sf:input path="rollNo" placeholder="${rollNo}  "
							class="form-control" />
					</c:otherwise>

				</c:choose>
			</div><sf:errors path="rollNo" cssClass="error" /><br></div></div>

	<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="studentId">
				<s:message code="label.student" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-user"></span>
				</div>
				<sf:select STYLE="width: 100%" size="0" path="studentId"
					class="form-control">
					<sf:option value="" label="Select" >
					------------------<s:message code="label.select"></s:message>------------------
					</sf:option>
					<sf:options items="${studentList}" itemValue="id" itemLabel="value" />
				</sf:select>
			</div><sf:errors path="studentId" cssClass="error" /><br></div></div>
<s:message code="marksheet.placeholder.chemistry" var="chemistry"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="chemistry">
				<s:message code="label.chemistry" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-pencil"></span>
				</div>
				<sf:input path="chemistry" placeholder="${chemistry } "
					class="form-control" />
			</div><sf:errors path="chemistry" cssClass="error" /><br></div></div>
		<s:message code="marksheet.placeholder.physics" var="physics"></s:message>
		
<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="physics">
				<s:message code="label.physics" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-pencil"></span>
				</div>
				<sf:input path="physics" placeholder="${physics } "
					class="form-control" />
			</div>
			<sf:errors path="physics" cssClass="error" /><br></div></div>
			<s:message code="marksheet.placeholder.maths" var="maths"></s:message>
			
<div class="form_group row">
				<div class="col-sm-4">
			<sf:label path="maths">
				<s:message code="label.maths" />
			</sf:label><font color="red">*</font>
				</div>
				<div class="col-sm-8">
			
			<div class="input-group">
				<div class="input-group-addon">
					<span class="glyphicon glyphicon-pencil"></span>
				</div>
				<sf:input path="maths" placeholder="${maths}"
					class="form-control" />
			</div>
			<sf:errors path="maths" cssClass="error" /><br></div></div>


			

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
								<span class="glyphicon glyphicon-refresh"></span>
								<s:message code="op.reset"></s:message>
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</sf:form>
	</div>
</div>