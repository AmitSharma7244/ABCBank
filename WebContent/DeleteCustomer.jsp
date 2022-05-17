<%@page import="com.abc.bean.Customer"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Delete Customer</title>
</head>
<body>
	
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	
	<% 
		Customer customer = (Customer ) request.getAttribute("customer");
		String message = (String ) request.getAttribute("message");
	%>
	<form action = "./CustomerController" method = "post">
	<input type = "hidden" name = "customerSSN" value = <%=customer.getCustomerSSN()%>>
		<div id = "updateInfoDiv">
			<h1 align = "center">Delete customer</h1>
			<table align = "center">
				<tr>
					<td align = "left">Customer SSN Id:</td>
					<td align = "left"><%=customer.getCustomerSSN() %></td>
				</tr>
				<tr>
					<td align = "left">Customer Id:</td>
					<td align = "left"><%=customer.getCustomerId() %></td>
				</tr>
				<tr>
					<td align = "left">Customer Name:</td>
					<td align = "left"><%=customer.getCustomerName() %></td>
				</tr>
				<tr>
					<td align = "left">Address:</td>
					<td align = "left"><%=customer.getAddress() %></td>
				</tr>
				<tr>
					<td align = "left">State:</td>
					<td align = "left"><%=customer.getState() %></td>
				</tr>
				<tr>
					<td align = "left">City:</td>
					<td align = "left"><%=customer.getCity() %></td>
				</tr>
				<tr>
					<td align = "left">Age:</td>
					<td align = "left"><%=customer.getAge() %></td>
				</tr>
			</table>
		</div>
		<center>
			<input type = "hidden" name = "action" value = "delete">
			<input type = "submit" name = "button" value = "Delete">
			<input type = "submit" name = "button" value = "Back">
		</center>
	</form>
	<%
		if(message != null) {
	%>
		<center><h1><%=message %></h1></center>
	<%
		}
	%>
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>