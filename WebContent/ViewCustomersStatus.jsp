<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Customers</title>
</head>
<body>
	
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	
	<form action = "./CustomerController" method = "post">
	<table align = "center" border = 1>
		
		<thead>
			<tr>
				<th align="right">Customer Id</th>
				<th align="right">Customer SSN Id</th>
				<th align="right">Status</th>
				<th align="right">Message</th>
				<th align="right">Last Updated</th>
				<th align="right">Operation</th>
				<th align="right">ViewProfile</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${customerList}" var = "customer">
				<tr>
					<td align="right">${customer.getCustomerId() }</td>
					<td align="right">${customer.getCustomerSSN()}</td>
					<td align="right">${customer.getStatus()}</td>
					<td align="right">${customer.getMessage()}</td>
					<td align="right">${customer.getLastUpdated()}</td>
					<td align="right"><a href = "">Refresh</a></td>
					<td align="right"><a href = "./CustomerController?source=viewDetails&id=${customer.getCustomerId() }">ViewDetails</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<center><input type = "submit" name = "button" value = "Back"></center>
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>