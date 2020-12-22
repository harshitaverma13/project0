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

th {
	text-align: center;
	color: white
}

td {
	text-align: center;
}
</style>
<title>MarkSheet Merit List</title>
</head>
<body>
	<div align="center">

		<div class="container text-center" style="background-color:#e46f1d6e; width:100%">
			<h2 class="text-primary" style="color: black; font-style: italic;">
				<b><s:message code="marksheet.label.marksheetMeritList"></s:message>
				</b>
			</h2>
		</div>
		<sf:form action="search" commandName="form" method="post" style="background-color:#e46f1d6e">
			<c:choose>
				<c:when test="${empty list}">
					<center>
						<input type="submit" name="operation" class="btn btn-primary"
							style="width: 5%" value="Back">
					</center>

				</c:when>
				<c:otherwise>
					<div class="table-responsive">
						<table class="table" height="40%" border="1"
							style="border-collapse: collapse; width: 100%;">
							<tr align="center" bgcolor="black">

								<th><s:message code="button.sNo" /></th>
								<th><s:message code="label.student" /></th>
								<th><s:message code="label.rollNo" /></th>
								<th><s:message code="label.chemistry" /></th>
								<th><s:message code="label.physics" /></th>
								<th><s:message code="label.maths" /></th>
								<th><s:message code="label.total" /></th>
								<th><s:message code="label.percentage"></s:message></th>
							</tr>

							<c:url var="editUrl" value="/Marksheet?id=" />

							<c:forEach items="${list}" var="marksheet" varStatus="ct">
								<c:if
									test="${marksheet.chemistry>33 && marksheet.physics>33 && marksheet.maths>33}">
									<tr>
										<td><c:out
												value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
										<td><c:out value="${marksheet.name}" /></td>
										<td><c:out value="${marksheet.rollNo}" /></td>
										<td><c:out value="${marksheet.chemistry}" /></td>
										<td><c:out value="${marksheet.physics}" /></td>
										<td><c:out value="${marksheet.maths}" /></td>
										<td><c:out
												value="${marksheet.maths  +marksheet.physics + marksheet.chemistry}" /></td>
										
												<c:set  var = "che" value = "${marksheet.chemistry}" />
												<c:set var = "phy" value = "${marksheet.physics}" />
												<c:set var = "maths" value = "${marksheet.maths}" />
										<td><fmt:formatNumber type = "number"
												value="${(che+phy+maths)/3}"
												maxFractionDigits="1"></fmt:formatNumber><c:out value=" %"></c:out> </td>


									</tr>
								</c:if>
							</c:forEach>



						</table>
						
					</div>
					<br>
					<table>
				<tr>
					<td align="center"><button type="button" name="submit" 
							onclick="history.back()" class="btn btn-primary"
							value="Back">
							<span class="glyphicon glyphicon-backward"></span>  <s:message code="button.back"></s:message></button>
						
						
						<a  class="btn btn-primary"target=blank; style="text-decoration: none;" href='<c:url value="/ctl/JasperCtl"></c:url>'><span style="color:white;"
							class="glyphicon glyphicon-print"></span><font color="white">  <s:message code="leble.print"/> </font> </a>
						
						</td>
				</tr>
			</table>
				</c:otherwise>
			</c:choose>
		</sf:form>
	</div>
</body>
</html>