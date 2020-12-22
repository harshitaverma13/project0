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
									code="subject.label.updateSubject"></s:message> </b></font>
					</c:when>
					<c:otherwise>
						<font color="black"><b><s:message
									code="subject.label.addSubject"></s:message> </b></font>
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
<s:message code="subject.placeholder.name" var="name"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="name">
						<s:message code="label.name" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-book"></span>
						</div>
						<sf:input path="name" placeholder="${name}"
							class="form-control" />
					</div>
					<sf:errors path="name" cssClass="error" />
					<br>
				</div>
			</div>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="courseId">
						<s:message code="subject.label.course" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-user"></span>
						</div>
						<sf:select STYLE="width: 100%" size="0" path="courseId"
							class="form-control">
							<sf:option value="" label="Select" >
							------------------<s:message code="label.select"></s:message>------------------
							</sf:option>
							<sf:options items="${courseList}" itemValue="id"
								itemLabel="value" />
						</sf:select>
					</div>
					<sf:errors path="courseId" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="course.placeholder.description" var="description"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="description">
						<s:message code="label.description" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-pencil"></span>
						</div>
						<sf:textarea path="description" placeholder="${description }"
							style="overflow: auto; resize: none" class="form-control" />
					</div>
					<sf:errors path="description" cssClass="error" />
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