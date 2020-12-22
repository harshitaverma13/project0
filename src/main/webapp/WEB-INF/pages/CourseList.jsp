<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>


<html>
<head>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

tr {
	display: table-row;
}

input[type=text] {
	border: 1px solid #456879;
	border-radius: 3px;
	height: 30px;
	width: 14%;
}

th {
	text-align: center;
	padding: 8px;
	color: white
}

td {
	text-align: center;
}
</style>

<title>Course List</title>
</head>
<body>

	<div class="container text-center" style="background-color:#e46f1d6e; width:100%">
		<h2 class="text-primary" style="color: black; font-style: italic;">
			<b><s:message code="course.label.courseList"></s:message> </b>
		</h2>
	
	<br>
	<div class=alert-success align="center"
		style="font-size: 150%; width: 40%; margin-left: 30%; background: transparent;">
		<b class="success">${success}</b>
	</div>

	<div class="alert-danger" align="center"
		style="width: 40%; font-size: 150%; margin-left: 30%; background: transparent;">

		<b class="error">${error}</b>
	</div>
	<br>
	</div>
	<sf:form action="search" commandName="form" method="post" style="background-color:#e46f1d6e">

		<sf:hidden path="pageNo" />
		<sf:hidden path="pageSize" />
		<c:choose>
			<c:when test="${empty list}">
				<center>
					<input type="submit" name="operation" class="btn btn-primary"
						style="width: 5%" value="<s:message code="button.back"></s:message>">
				</center>

			</c:when>
			<c:otherwise>
			<s:message code="course.placeholder.name" var="name"></s:message>
					
				<div class="form-inline" align="center">
					<div class=" col-sm-1"></div>
					<label class=" col-sm-2" style="text-align: right;"><b><s:message
								code="label.name" />: </b></label>
					<div class="col-sm-2">
						<sf:input path="name" class="form-control" id="courseName"
							style="width: 100%" placeholder="${name}" />
					</div>

<s:message code="course.placeholder.duration" var="duration"></s:message>

					<label class=" col-sm-1" style="text-align: right;"><b><s:message
								code="course.label.duration" />:</b></label>
					<div class="col-sm-2">
						<sf:input path="duration" class="form-control" id="duration"
							style="width: 100%" placeholder="${duration }" />

					</div>

					<div class=" col-sm-1">
						<button type="submit" class="btn btn-success" name="operation"
							value="Search">
							<span class="glyphicon glyphicon-search"></span>
							<s:message code="button.search" />
						</button>
					</div>
					<div class="col-sm-1">
						<button type="submit" class="btn btn-info" name="operation"
							value="Reset">
							<span class="glyphicon glyphicon-refresh"></span>
							<s:message code="button.reset" />
						</button>
					</div>

				</div>

				<br>
				<br>
				<br>

				<div class="table-responsive">

					<table class="table" height="40%" bgcolor="" border="1"
						style="border-collapse: collapse; width: 100%;">
						<tr align="center" bgcolor="black">
							<th align="center" width="90" style="padding: 4px; color: white"><input
								type="checkbox" onclick="selectAll(this)"></th>
							<th><s:message code="button.sNo" /></th>
							<th><s:message code="label.name" /></th>
							<th><s:message code="course.label.duration" /></th>
							<th><s:message code="label.description" /></th>
							<th><s:message code="button.edit" /></th>
						</tr>
						<c:url var="editUrl" value="/ctl/Course?id=" />
						<c:forEach items="${list}" var="course" varStatus="ct">
							<tr>

								<td><input type="checkbox" name="ids" value="${course.id}"></td>
								<td><c:out
										value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
								<td><c:out value="${course.name}" /></td>
								<td><c:out value="${course.duration}" /></td>
								<td><c:out value="${course.description}" /></td>
								<td><a href="${editUrl}${course.id}" style="color: blue;"><span
										class="glyphicon glyphicon-edit"></span> <b> <s:message
												code="button.edit" /></b></a></td>
							</tr>
						</c:forEach>
					</table>
					<br>
				</div>
				<div>
					<div class="form-inline" align="center">
						<c:choose>
							<c:when test="${form.pageNo==1}">
								<div class="col-sm-offset col-sm-3">
									<button type="submit" class="btn btn-primary" name="operation"
										disabled="disabled" value="Previous">
										<span class="glyphicon glyphicon-backward"> </span>
										<s:message code="button.previos" />
									</button>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-sm-offset col-sm-3">
									<button type="submit" class="btn btn-primary" name="operation"
										value="Previous">
										<span class="glyphicon glyphicon-backward"> </span>
										<s:message code="button.previos" />
									</button>
								</div>
							</c:otherwise>

						</c:choose>



						<div class="col-sm-offset col-sm-3">
							<button type="submit" name="operation" class="btn btn-danger"
								value="Delete">
								<span class="glyphicon glyphicon-trash"></span>
								<s:message code="button.delete" />
							</button>
						</div>


						<div class="col-sm-offset col-sm-3">
							<a class="btn btn-info" href='<c:url value="/ctl/Course" />'><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="button.new" /></a>
						</div>


						<c:choose>
							<c:when test="${list.size()==form.pageSize && !((courseList.size()==form.pageSize*form.pageNo))}">
								<div class="col-sm-offset col-sm-3">
									<button type="submit" class="btn btn-primary" name="operation"
										 value="Next">
										<s:message code="button.next" />
										<span class="glyphicon glyphicon-forward"> </span>
									</button>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-sm-offset col-sm-3">
									<button type="submit" class="btn btn-primary" name="operation" disabled="disabled"
										value="Next">
										<s:message code="button.next" />
										<span class="glyphicon glyphicon-forward"> </span>
									</button>
								</div>
							</c:otherwise>

						</c:choose>




						<br> <br>
					</div>
				</div>


			</c:otherwise>
		</c:choose>
	</sf:form>
</body>
</html>
