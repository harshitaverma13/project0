<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<div class="container">
	<div class="card card-container" style="background-color:#e46f1d6e">
		<div align="center" style="font-style: italic; color: white">
			<h2 style="color: white">
				<c:choose>

					<c:when test="${form.id>0}">
						<font color="black"><b><s:message
									code="timetable.label.updateTimeTable"></s:message> </b></font>
					</c:when>
					<c:otherwise>
						<font color="black"><b><s:message
									code="timetable.label.addTimeTable"></s:message> </b></font>
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

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="courseId">
						<s:message code="timetable.label.course" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-book" style="font-size: 13px"></span>
						</div>
						<sf:select STYLE="width: 100%" size="0" path="courseId"
							class="form-control">
							<sf:option value="" label="Select">
							------------------<s:message code="label.select"></s:message>------------------
							</sf:option>
							<sf:options items="${courseList}" itemValue="id" itemLabel="name" />
						</sf:select>
					</div>
					<sf:errors path="courseId" cssClass="error" />
					<br>
				</div>
			</div>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="subjectId">
						<s:message code="timetable.label.subject" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-book" style="font-size: 13px"></span>
						</div>
						<sf:select STYLE="width: 100%" size="0" path="subjectId"
							class="form-control">
							<sf:option value="" label="Select">------------------<s:message
									code="label.select"></s:message>------------------</sf:option>
							<sf:options items="${subjectList}" itemValue="id"
								itemLabel="name" />
						</sf:select>
					</div>
					<sf:errors path="subjectId" cssClass="error" />
					<br>
				</div>
			</div>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="semester">
						<s:message code="timetable.label.semester" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-pencil" style="font-size: 13px"></span>
						</div>
						<sf:select STYLE="width: 100%" size="0" path="semester"
							class="form-control">
							<sf:option value="" label="Select" >
							------------------<s:message code="label.select"></s:message>------------------
							</sf:option>
							<sf:option value="1st" label="1st" >
							<s:message code="TimeTable.semester.1st"/>
							</sf:option>
							<sf:option value="2nd" label="2nd"><s:message code="TimeTable.semester.2st"/></sf:option>
							<sf:option value="3rd" label="3rd"><s:message code="TimeTable.semester.3st"/></sf:option>
							<sf:option value="4th" label="4th" ><s:message code="TimeTable.semester.4st"/></sf:option>
							<sf:option value="5th" label="5th" ><s:message code="TimeTable.semester.5st"/></sf:option>
							<sf:option value="6th" label="6th" ><s:message code="TimeTable.semester.6st"/></sf:option>
							<sf:option value="7th" label="7th" ><s:message code="TimeTable.semester.7st"/></sf:option>
							<sf:option value="8th" label="8th" ><s:message code="TimeTable.semester.8st"/></sf:option>
						</sf:select>
					</div>
					<sf:errors path="semester" cssClass="error" />
					<br>
				</div>
			</div>


			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="examTime">
						<s:message code="timetable.label.examTime" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"
								style="font-size: 13px"></span>
						</div>
						<sf:select STYLE="width: 100%" size="0" path="examTime"
							class="form-control">
							<sf:option value="" label="Select" >
							------------------<s:message code="label.select"></s:message>------------------
							</sf:option>
							<sf:option value="7:00 AM TO 10:00 AM"
								label="7:00 AM TO 10:00 AM">
								<s:message code="TimeTable.examTime.1st"></s:message>
								</sf:option>
							<sf:option value="10:00 AM TO 1:00 PM"
								label="10:00 AM TO 1:00 PM" >
								<s:message code="TimeTable.examTime.2st"></s:message>
								</sf:option>
							<sf:option value="1:00 PM TO 3:00 PM" label="1:00 PM TO 3:00 PM" >
							<s:message code="TimeTable.examTime.3st"></s:message>
							</sf:option>
							<sf:option value="3:00 PM TO 6:00 PM" label="3:00 PM TO 6:00 PM" ><s:message code="TimeTable.examTime.4st"></s:message>
							</sf:option>
						</sf:select>
					</div>
					<sf:errors path="examTime" cssClass="error" />
					<br>
				</div>
			</div>
<s:message code="timeTable.placeholder.examDate" var="examDate"></s:message>

			<div class="form_group row">
				<div class="col-sm-4">
					<sf:label path="examDate">
						<s:message code="timetable.label.examDate" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-8">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-calendar"></span>
						</div>
						<sf:input path="examDate" readonly="true"
							placeholder="${examDate}" class="form-control" />
					</div>
					<sf:errors path="examDate" cssClass="error" />
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
<script>
	var dateToday = new Date();
	$(function() {
		$("#examDate").datepicker({
			changeMonth : true,
			changeYear : true,
			changeDay : true,
			showWeekNumbers : true,
			showMonthAfterYear : true,
			minDate : +1,
			yearRange : "-70:+20",

			dateFormat : "mm/dd/yy",

		});
	});

	
</script>