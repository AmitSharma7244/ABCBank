<%@page import="com.abc.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
</head>
<body>
	
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	
	<%
		Account account = (Account) request.getAttribute("account");
	%>
	
		<div id = "detailsDiv">
			<h1 align = "center">Customer Details</h1>
			<table align = "center">
				<tr>
					<td align = "left">Customer SSN Id:</td>
					<td align = "left"><%=account.getAccountId() %></td>
				</tr>
				<tr>
					<td align = "left">Customer Id:</td>
					<td align = "left"><%=account.getCustomerId() %></td>
				</tr>
				<tr>
					<td align = "left">Customer Name:</td>
					<td align = "left"><%=account.getAccountType() %></td>
				</tr>
			</table>
		</div>
	
	<center>
		<button onclick="history.back()"> Back </button>
	</center>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>