

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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

<title>Marksheet List</title>
</head>
<body>

	<div class="container text-center" style="background-color:#e46f1d6e; width:100%">
		<h2 class="text-primary" style="color: black; font-style: italic;">
			<b><s:message code="marksheet.label.marksheetList"></s:message> </b>
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
				<div class="form-inline" align="center">
					<div class=" col-sm-2"></div>
					<label class=" col-sm-1" for="name" style="text-align: right;"><b><s:message
								code="label.student" />: </b></label>
					<div class="col-sm-2">
						<sf:select path="studentId" class="form-control"
							style="width: 100%">
							<sf:option value="" label="Select" >
							------------<s:message code="label.select"></s:message>------------
							</sf:option>
							<sf:options items="${studentList}" itemValue="id"
								itemLabel="value" />
						</sf:select>
					</div>
<s:message code="marksheet.placeholder.rollNo" var="rollNo"></s:message>


					<label class=" col-sm-1" for="rollNo" style="text-align: right;"><b><s:message
								code="label.rollNo" />: </b></label>
					<div class="col-sm-2">
						<sf:input path="rollNo" class="form-control" style="width: 100%"
							placeholder="${rollNo }" />

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
				<br>
				<div class="table-responsive">
					<table class="table" height="40%" border="1"
						style="border-collapse: collapse; width: 100%;">
						<tr align="center" bgcolor="black">

							<th align="center" width="90" style="padding: 4px; color: white"><input
								type="checkbox" onclick="selectAll(this)"></th>

							<th><s:message code="button.sNo" /></th>
							<th><s:message code="label.student" /></th>
							<th><s:message code="label.rollNo" /></th>
							<th><s:message code="label.chemistry" /></th>
							<th><s:message code="label.physics" /></th>
							<th><s:message code="label.maths" /></th>
							<th><s:message code="label.total" /></th>
							<th><s:message code="label.percentage" /></th>
							<th><s:message code="label.status" /></th>
							<th><s:message code="button.edit" /></th>
						</tr>

						<c:url var="editUrl" value="/ctl/Marksheet?id=" />


						<c:forEach items="${list}" var="marksheet" varStatus="ct">
							<tr>
								<td><input type="checkbox" name="ids"
									value="${marksheet.id}"></td>
								<td><c:out
										value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
								<td><c:out value="${marksheet.name}" /></td>


								<td><c:out value="${marksheet.rollNo}" /></td>
								<c:choose>
									<c:when test="${marksheet.chemistry>33}">
										<td><c:out value="${marksheet.chemistry}" /></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="${marksheet.chemistry}" /><font
											color="red">*</font></td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${marksheet.physics>33}">
										<td><c:out value="${marksheet.physics}" /></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="${marksheet.physics}" /><font
											color="red">*</font></td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${marksheet.maths>33}">
										<td><c:out value="${marksheet.maths}" /></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="${marksheet.maths}" /><font color="red">*</font></td>
									</c:otherwise>
								</c:choose>

								<td><c:out
										value="${marksheet.maths  +marksheet.physics + marksheet.chemistry}" /></td>
										<td><fmt:formatNumber type = "number"
												value="${(marksheet.maths  +marksheet.physics + marksheet.chemistry)/3}"
												maxFractionDigits="1"></fmt:formatNumber><c:out value=" %"></c:out> </td>
										
								
								<c:choose>
									<c:when
										test="${marksheet.chemistry>=33 && marksheet.physics>=33 && marksheet.maths>=33}">
										<td style="color: green;"><b><s:message code="getMarksheet.lable.statusPass"/> </b></td>
									</c:when>
									<c:otherwise>
										<td style="color: red;"><b><s:message code="getMarksheet.lable.statusFail"/></b></td>
									</c:otherwise>
								</c:choose>
								<td><a href="${editUrl}${marksheet.id}"
									style="color: blue;"><span class="glyphicon glyphicon-edit"></span>
										<b> <s:message code="button.edit" /></b></a></td>
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
							<a class="btn btn-info" href='<c:url value="/ctl/Marksheet" />'><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="button.new" /></a>
						</div>


						<c:choose>
							<c:when test="${list.size()==form.pageSize && !((marksheetList.size()==form.pageSize*form.pageNo))}">
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