<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	color: white;
	text-align: center;
}

td {
	text-align: center;
	color: black;
}
</style>
</head>
<body>

	<div class="container text-center" style="background-color:#e46f1d6e; width:100%">
		<h2 class="text-primary" style="color: black; font-style: italic;">
			<b><s:message code="header.userList" /> </b>
		</h2>
	

	<c:url var="editUrl" value="/ctl/User?id=" />

	<br>

	<div class=alert-success align="center" 
		style="font-size: 150%; width: 40%; margin-left: 30%;background: white; ">
		<b class="success">${success}</b>
	</div>

   <div class="alert-danger" align="center"
		style="width: 40%; font-size: 150%; margin-left: 30%;background: white;">

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
<s:message code="user.placeholder.firstName" var="firstName"></s:message>

				<div align="center">

					<font color="white"><label class=" col-sm-2"><b><s:message
								code="label.firstName" />:</b></label></font>
					<div class="col-sm-offset col-sm-2">
						<sf:input path="firstName" class="form-control"
							style="width: 100%; " placeholder="${firstName }" />
					</div>
<s:message code="user.placeholder.login" var="login"></s:message>


					<font color="white"><label class=" col-sm-1" for="login"><b><s:message
								code="user.label.login" />:</b></label></font>
					<div class="col-sm-2">
						<sf:input path="login" class="form-control" style="width: 100%"
							placeholder="${login }" />
					</div>

					<font color="white"><label class="col-sm-1"><b><sf:label path="roleId">
								<s:message code="user.label.role" />
							</sf:label>:</b></label></font>
					<div class="col-sm-2">
						<sf:select STYLE="width: 100%" size="0" path="roleId"
							class="form-control">
							<sf:option value="" label="Select" >
							------------<s:message code="label.select"></s:message>------------
							</sf:option>
							<sf:options items="${roleList}" itemValue="id"
								itemLabel="roleName" />
						</sf:select>
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
					<table class="table" border="1"
						style="border-collapse: collapse; width: 100%; height: 40%;">
						<c:if test="${!empty list}">
							<tr align="center" bgcolor="black">
								<th align="center" width="90" style="padding: 4px; color: white"><input
									type="checkbox" onclick="selectAll(this)"></th>
								<th><s:message code="button.sNo" /></th>
								<th><s:message code="label.firstName" /></th>
								<th><s:message code="label.lastName" /></th>
								<th><s:message code="label.login" /></th>
								<th><s:message code="label.dob" /></th>
								<th><s:message code="label.mobileNo" /></th>
								<th><s:message code="label.role" /></th>
								<th><s:message code="label.gender" /></th>
								<th><s:message code="button.edit" /></th>
							</tr>


							<c:forEach items="${list}" var="user" varStatus="ct">
								<tr>
								<c:choose>
									<c:when test="${user.roleId==1}">
									<td><input type="checkbox" name="ids" disabled="disabled" value="${user.id}"></td>
									</c:when>
									<c:otherwise>
									<td><input type="checkbox" name="ids" value="${user.id}"></td>
									</c:otherwise>
									
									</c:choose>
								
									
									<td><c:out
											value="${(form.pageSize * (form.pageNo-1))+ct.index+1}" /></td>
									<td><c:out value="${user.firstName}" /></td>
									<td><c:out value="${user.lastName}" /></td>
									<td><c:out value="${user.login}"></c:out></td>
									<td><fmt:formatDate value="${user.dob}"/> </td>
									
									<td><c:out value="${user.mobileNo}" /></td>
									
									<c:if test="${user.roleId==1}">
									<td>Admin</td>
									</c:if>
									<c:if test="${user.roleId==2}">
									<td>Student</td>
									</c:if>
									<c:if test="${user.roleId==3}">
									<td>College</td>
									</c:if>
									<c:if test="${user.roleId==4}">
									<td>KIOSK</td>
									</c:if>
									<c:if test="${user.roleId==5}">
									<td>Faculty</td>
									</c:if>
									
									<td><c:out value="${user.gender}"></c:out></td>
									<c:choose>
									<c:when test="${user.roleId==1}">
									<td><a style="text-decoration: none;">---</a></td>
									
									</c:when>
									<c:otherwise>
									<td><a href="${editUrl}${user.id}" style="color:teal;"><span
											class="glyphicon glyphicon-edit"></span><b> <s:message
													code="button.edit" /></b></a></td>
									</c:otherwise>
									
									</c:choose>
									
									
								</tr>
							</c:forEach>
						</c:if>
					</table>
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
							<a class="btn btn-info" href='<c:url value="/ctl/User" />'><span
								class="glyphicon glyphicon-plus"></span> <s:message
									code="button.new" /></a>
						</div>

   <%-- ${list.size()==form.pageSize && !((userList.size()==form.pageSize*form.pageNo))} --%>
						<c:choose>
							<c:when test="${list.size()==form.pageSize && !((userList.size()==form.pageSize*form.pageNo))}">
								<div class="col-sm-offset col-sm-3">
									<button type="submit" class="btn btn-primary" name="operation"
										 value="Next">
										<s:message code="button.next" />
										<span class="glyphicon glyphicon-forward"> </span>
									</button>
								</div>
							</c:when>
							<c:otherwise>							<div class="col-sm-offset col-sm-3">
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