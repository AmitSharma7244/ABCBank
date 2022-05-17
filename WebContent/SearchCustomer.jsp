<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search Customer</title>
</head>
<body>

	<jsp:include page="CustomerHeader.jsp"></jsp:include>

	<% 
		String errorMessage = (String ) request.getAttribute("message"); 
		String function = (String ) request.getAttribute("function");
	%>
	<h1 align = "center">Search Customer by</h1>
	
	<div id = "searchDiv">
		<form action = "./CustomerController" method = "post">
			<input type = "hidden" name = "function" value = <%=function %>>
			<input type = "hidden" name = "action" value = "search">
			<table align = "center">
				
				<tr>
					<td>Enter SSN Id:</td>
					<td><input type = "text" name = "customerSSN"></td>
				</tr>
				<tr>
					<td>OR</td>
				</tr>
				<tr>
					<td>Enter Customer Id:</td>
					<td><input type = "text" name = "customerId"></td> 
				</tr>
				
			</table>
			<center>
				<input type = "submit" name = "button" value = "Search">
				<input type = "submit" name = "button" value = "Back">
			</center>
		</form>
	</div>
	
	<div id = "errorDiv">
		<center><h1><%=errorMessage %></h1></center>
	</div>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>