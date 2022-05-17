<%@page import="com.abc.bean.Customer"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Update Customer</title>
</head>
<body>
	
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	
	<%
		Customer customer = (Customer) request.getAttribute("customer");
	%>
	
	<form action = "./CustomerController" method = "post">
	<input type = "hidden" name = "customerSSN" value = <%=customer.getCustomerSSN()%>>
		<div id = "updateInfoDiv">
			<h1 align = "center">Update customer</h1>
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
					<td align = "left">Old Customer Name:</td>
					<td align = "left"><%=customer.getCustomerName() %></td>
				</tr>
				<tr>
					<td align = "left">New Customer Name:*</td>
					<td align = "left"><input type = "text" name = "newName"></td>
				</tr>
				<tr>
					<td align = "left">Old Address:</td>
					<td align = "left"><%=customer.getAddress() %></td>
				</tr>
				<tr>
					<td align = "left">New Address:*</td>
					<td align = "left"><input type = "text" name = "newAddress"></td>
				</tr>
				<tr>
					<td align = "left">Old State:</td>
					<td align = "left"><%=customer.getState() %></td>
				</tr>
				<tr>
					<td align = "left">New State:*</td>
					<td align = "left">
						<select name = "newState">
						<option value = "Select">Select</option>
						<option value="Andhra Pradesh">Andhra Pradesh</option>
						<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
						<option value="Arunachal Pradesh">Arunachal Pradesh</option>
						<option value="Assam">Assam</option>
						<option value="Bihar">Bihar</option>
						<option value="Chandigarh">Chandigarh</option>
						<option value="Chhattisgarh">Chhattisgarh</option>
						<option value="Dadar and Nagar Haveli">Dadar and Nagar Haveli</option>
						<option value="Daman and Diu">Daman and Diu</option>
						<option value="Delhi">Delhi</option>
						<option value="Lakshadweep">Lakshadweep</option>
						<option value="Puducherry">Puducherry</option>
						<option value="Goa">Goa</option>
						<option value="Gujarat">Gujarat</option>
						<option value="Haryana">Haryana</option>
						<option value="Himachal Pradesh">Himachal Pradesh</option>
						<option value="Jammu and Kashmir">Jammu and Kashmir</option>
						<option value="Jharkhand">Jharkhand</option>
						<option value="Karnataka">Karnataka</option>
						<option value="Kerala">Kerala</option>
						<option value="Madhya Pradesh">Madhya Pradesh</option>
						<option value="Maharashtra">Maharashtra</option>
						<option value="Manipur">Manipur</option>
						<option value="Meghalaya">Meghalaya</option>
						<option value="Mizoram">Mizoram</option>
						<option value="Nagaland">Nagaland</option>
						<option value="Odisha">Odisha</option>
						<option value="Punjab">Punjab</option>
						<option value="Rajasthan">Rajasthan</option>
						<option value="Sikkim">Sikkim</option>
						<option value="Tamil Nadu">Tamil Nadu</option>
						<option value="Telangana">Telangana</option>
						<option value="Tripura">Tripura</option>
						<option value="Uttar Pradesh">Uttar Pradesh</option>
						<option value="Uttarakhand">Uttarakhand</option>
						<option value="West Bengal">West Bengal</option>
					</select>
					</td>
				</tr>
				<tr>
					<td align = "left">Old City:</td>
					<td align = "left"><%=customer.getCity() %></td>
				</tr>
				<tr>
					<td align = "left">New City:*</td>
					<td align = "left"><input type = "text" name = "newCity"></td>
				</tr>
				<tr>
					<td align = "left">Old Age:</td>
					<td align = "left"><%=customer.getAge() %></td>
				</tr>
				<tr>
					<td align = "left">New Age:*</td>
					<td align = "left"><input type = "text" name = "newAge"></td>
				</tr>
			</table>
		</div>
		<center>
			<input type = "hidden" name = "action" value = "update">
			<input type = "submit" name = "button" value = "Update">
			<input type = "submit" name = "button" value = "Back">
		</center>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>