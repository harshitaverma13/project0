<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>

<html>
<head>
<style type="text/css">
table {
	border-collapse: collapse;
	
}

tr {
	display: table-row;
}

th {
	text-align: center;
	color: white
}

td {
	text-align: center;
}
</style>

<title>Get MarkSheet</title>
</head>
<body>


	<div class="container-fluid">
		<sf:form method="Post" commandName="form" style="background-color:#e46f1d6e; margin-top:30; width:100%">
			<div class="container text-center">
				<h2 class="text-primary" style="color: black; font-style: italic;">
					<b><s:message code="header.getMarksheet"></s:message>
					</b>
				</h2>
			
			<br>
			<div class=alert-success align="center"
				style="font-size: 150%; width: 40%; margin-left: 30%">
				<b>${success}</b>
			</div>



			<div class="alert-danger" align="center"
				style="width: 40%; font-size: 150%; margin-left: 30%">

				<b>${error}</b>
			</div>
			<br>
			</div>
			<div class="form_group row" style="margin-left: 30%">
				<div class="control-label col-sm-2">
<s:message code="marksheet.placeholder.rollNo" var="rollNo"></s:message>
			
					<sf:label path="rollNo">
						<s:message code="label.rollNo" />
					</sf:label>
					<font color="red">*</font>
				</div>
				<div class="col-sm-4">

					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-tag"></span>
						</div>
						<sf:input path="rollNo" class="form-control" id="rollNo"
							name="rollNo" placeholder="${rollNo }" />
					</div>
					<sf:errors path="rollNo" cssClass="error" />
					<br>
				</div>
				<div class="col-sm-2">
				<button type="submit" name="operation" class="btn btn-success"
					value="Go">
					<span class="glyphicon glyphicon-ok-sign"></span>
					<s:message code="button.go" />
				</button>
				</div>
			</div>
			
				
			
			
			<br>
			<br>
			<br>

			<c:if test="${(error==null)&&(not empty form.rollNo)}">
				<div class="container" style="width: 50%;">

					<table class="table table-hover" border="4" bordercolor="black">
						<tr
							style="background-color: #5184d6; color: white; width:100% text-align: left;">

							<td><font color="white"><b><s:message
											code="label.rollNo" /> :</b></font> <font color="black"><b><c:out
											value="${form.rollNo}" /></b></font></td>

							<td><font color="white"><b><s:message
											code="label.name" /> :</b></font> <font color="black"><b><c:out
											value="${form.name}" /></b></font></td>
						</tr>
					</table>


					<table class="table table-hover" border="4" bordercolor="black">
						<tr style="background-color: #5184d6; color: white""text-left">



							<td height="35"><b><s:message
										code="getMarksheet.lable.subjectName"></s:message> </b></td>

							<td height="35"><b><s:message
										code="getMarksheet.lable.maxMarks"></s:message></b></td>

							<td height="35"><b><s:message
										code="getMarksheet.lable.minMarks"></s:message></b></td>

							<td height="35"><b><s:message
										code="getMarksheet.lable.obtainedMarks"></s:message></b></td>

							<td><b><s:message code="getMarksheet.lable.distinction"></s:message></b></td>
						</tr>
						<tr>
							<td height="35"><b><s:message code="label.physics" /></b></td>

							<td height="35"><b>100</b></td>

							<td height="35"><b>33</b></td>
							<td height="35"><c:choose>
									<c:when test="${form.physics>=33}">
										<b><c:out value="${form.physics}"></c:out> </b>
									</c:when>
									<c:otherwise>
										<b><c:out value="${form.physics}"></c:out> </b>
										<font color="red"><b>*</b></font>
									</c:otherwise>
								</c:choose></td>
							<td height="35"><c:if test="${form.physics>=75}">
									<b> D </b>
								</c:if></td>
						</tr>
						<tr>
							<td><b><s:message code="label.chemistry" /></b></td>

							<td><b>100</b></td>

							<td><b>33</b></td>

							<td height="35"><c:choose>
									<c:when test="${form.chemistry>=33}">
										<b><c:out value="${form.chemistry}"></c:out> </b>
									</c:when>
									<c:otherwise>
										<b><c:out value="${form.chemistry}"></c:out> </b>
										<font color="red"><b>*</b></font>
									</c:otherwise>
								</c:choose></td>
							<td height="35"><c:if test="${form.chemistry>=75}">
									<b> D </b>
								</c:if></td>


						</tr>
						<tr>
							<td height="35"><b><s:message code="label.maths" /></b></td>

							<td height="35"><b>100</b></td>

							<td height="35"><b>33</b></td>

							<td height="35"><c:choose>
									<c:when test="${form.maths>=33}">
										<b><c:out value="${form.maths}"></c:out> </b>
									</c:when>
									<c:otherwise>
										<b><c:out value="${form.maths}"></c:out> </b>
										<font color="red"><b>*</b></font>
									</c:otherwise>
								</c:choose></td>
							<td height="35"><c:if test="${form.maths>=75}">
									<b> D </b>
								</c:if></td>

						</tr>
						<tr>

							<td height="35"></td>
							<td height="35"></td>
							<td height="35"><b><s:message code="label.total" /></b></td>

							<td height="35"><b><c:out
										value="${form.maths  +form.physics + form.chemistry}" />/300</b></td>
							<td></td>

						</tr>
					</table>

					<c:set var="percentage"
						value="${((marksheet.maths  +marksheet.physics + marksheet.chemistry)/3)}"></c:set>

					<table class="table table-hover" border="4" bordercolor="black">
						<tr style="background-color: #5184d6; color: white""text-left">
							<c:if
								test="${percentage>=60&&marksheet.chemistry>33 && marksheet.physics>33 && marksheet.maths>33}">
								<td align="center">Status</td>
								<td align="center" height="35"><font color="black"><b><s:message
												code="getMarksheet.lable.statusFirst"></s:message> </b></font></td>
							</c:if>
							<c:if
								test="${percentage>=45&&percentage<60 &&marksheet.chemistry>33 && marksheet.physics>33 && marksheet.maths>33}">
								<td align="center">Status</td>
								<td align="center"><font color="black"><b><s:message
												code="getMarksheet.lable.statusSecond"></s:message></b></font></td>
							</c:if>
							<c:if
								test="${percentage>=33&&percentage<45 &&marksheet.chemistry>33 && marksheet.physics>33 && marksheet.maths>33}">
								<td align="center">Status</td>
								<td height="35"><font color="black"><b><s:message
												code="getMarksheet.lable.statusThird"></s:message></b></font></td>
							</c:if>
							<c:if
								test="${marksheet.chemistry>33 && marksheet.physics>33 && marksheet.maths>33}">
								<td align="center">Status</td>
								<td align="center"><font color="red"><b><s:message
												code="getMarksheet.lable.statusFail"></s:message></b> </font></td>
							</c:if>


						</tr>
					</table>
				</div>



			</c:if>
		</sf:form>
	</div>
</body>
</html>