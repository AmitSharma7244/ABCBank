<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Customer</title>
</head>
<body>
	
	<jsp:include page="CustomerHeader.jsp"></jsp:include>
	
	<% String message = (String) request.getAttribute("message"); %>
	
	<form action = "./CustomerController" method = "post">
		
		<h1 align = "center">Add Customer</h1>
		<input type = "hidden" name = "action" value = "add">
		<center>
			<div class = "container" style = "padding-left: 28%;">
				<div class = "form-group row">
					<label for = "CustomerSSNId" class="col-sm-3 col-form-label">Customer SSN Id*</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="customerSSN" placeholder="Enter SSN Id">
					</div>
				</div>
				<div class = "form-group row">
					<label for = "CustomerName" class="col-sm-3 col-form-label">Customer Name*</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="customerName" placeholder="Enter Name">
					</div>
				</div>
				<div class = "form-group row">
					<label for = "CustomerAge" class="col-sm-3 col-form-label">Age*</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="age" placeholder="Enter Age">
					</div>
				</div>
				<div class = "form-group row">
					<label for = "CustomerAddress" class="col-sm-3 col-form-label">Address*</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="address" placeholder="Enter Address">
					</div>
				</div>
				<div class = "form-group row">
					<label for = "CustomerState" class="col-sm-3 col-form-label">State*</label>
					<select name = "state" class="form-control col-sm-3">
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
				</div>
				<div class = "form-group row">
					<label for = "CustomerCity" class="col-sm-3 col-form-label">City*</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="city" placeholder="Enter City">
					</div>
				</div>
			</div>
			
			<div class="d-flex flex-row justify-content-center">
				<div class="p-2">
					<input type = "submit" name = "button" value = "Submit"> 
				</div>
				<div class="p-2">
				  	<input type = "submit" name = "button" value = "Back"> 
				</div>
			</div>
		</center>
		
		<% if(message != null) { %>
			<center><p><%=message%></p></center>
		<% } %>
	</form>
	
	<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>