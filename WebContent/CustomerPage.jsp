<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Customer</title>
</head>
<body>
	
	<% 
		String username = (String) session.getAttribute("usesrname"); 
	%>
	
	<h1 align = "center"> Welcome ${username}</h1>
	
	<p align = "center"><a href="./CustomerController?source=add">Add Customer</a></p>
	<p align = "center"><a href="./CustomerController?source=view">View Customer Status</a></p>
	<p align = "center"><a href="./CustomerController?source=search">Search Customers</a></p>
	<p align = "center"><a href="./CustomerController?source=update">Update Customer</a></p>
	<p align = "center"><a href="./CustomerController?source=delete">Delete Customer</a></p>
	
	<p align = "center"><a href="./AccountController?source=create">Create Account</a></p>
	<p align = "center"><a href="./AccountController?source=search">Search Account</a></p>
	<p align = "center"><a href="./AccountController?source=delete">Delete Account</a></p>
	<p align = "center"><a href="./AccountController?source=view">View Account Status</a></p>
	<hr>
	<center><a href = "./LogoutServlet">Logout</a></center>
</body>
</html>