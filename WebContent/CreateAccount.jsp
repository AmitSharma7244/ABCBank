<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>

	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	
	<% String message = (String) request.getAttribute("message"); %>
	
	<form action = "./AccountController" method = "post">
		<center><h1>Create Amount</h1></center>
		<input type = "hidden" name = "action" value = "create">
		<table align = "center">
			<tr>
				<td>Customer Id*</td>
				<td><input type = "text" name = "customerId"></td>
			</tr>
			<tr>
				<td>Account type*</td>
				<td>
					<select name = "accountType">
						<option value = "Select">Select</option>
						<option value="current">Current</option>
						<option value="savings">Savings</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Deposit Amount*</td>
				<td><input type = "text" name = "depositAmount"></td>
			</tr>
		</table>
		
		<p align = "center">
			<input type = "submit" name = "button" value = "Submit"> 
			<input type = "submit" name = "button" value = "Back">
		</p>
		
		<% if(message != null) { %>
			<center><p><%=message%></p></center>
		<% } %>
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>