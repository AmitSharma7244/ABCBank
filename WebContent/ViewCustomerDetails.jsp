<%@page import="com.abc.bean.Customer"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
	
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	
	<%
		Customer customer = (Customer) request.getAttribute("customer");
	%>
	<form action = "./CustomerController">
		
		<input type = "hidden" name = "id" value = <%=customer.getCustomerId() %>>
		<div id = "detailsDiv">
			<h1 align = "center">Customer Details</h1>
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
					<td align = "left">Age:</td>
					<td align = "left"><%=customer.getAge() %></td>
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
			</table>
		</div>
		<div>
		<center>
			<input type = "submit" name = "source" value = "Update">
			<input type = "submit" name = "source" value = "Delete">
		</center>
		</div>
	</form>
	
	
		<center>
			<button onclick="history.back()"> Back </button>
		</center>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>