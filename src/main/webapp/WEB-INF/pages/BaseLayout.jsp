<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<style>
.error {
	color: red;
	font-weight:600;
}

.success {
	color: green;
	font-weight: 600;
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BaseLayout</title>
</head>
<body>

	  <div style="margin-bottom: 0px;"> 
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-3 col-md-1 " >
				<tiles:insertAttribute name="menu" ></tiles:insertAttribute>
				</div>
				<div class=" col-xs-9 col-md-11 " style="min-height: 526px; background-color: ;margin-left:auto;">
					<tiles:insertAttribute name="body"></tiles:insertAttribute>
				</div>
			</div>
	
		</div>
		
		<div style="clear: both; margin-top: 50px;">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>  


	 <%-- <table  cellspacing="2" align="center" width="100%">
		<tr>
			<td colspan="2" height="100px">
			<tiles:insertAttribute name="header"></tiles:insertAttribute></td>
		</tr>
		<tr width="100%">
			<td class="col-xs-2 col-md-1 "  height="400px" valign="top" >
			<tiles:insertAttribute name="menu"></tiles:insertAttribute></td>
			
			<td class="col-xs-10 col-md-11 " height="400px" valign="top" >
			<tiles:insertAttribute name="body"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute></td>
		</tr>

	</table>  --%>

</body>
</html>