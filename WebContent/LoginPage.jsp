<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="LoginPage.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<% String errorMessage = (String ) request.getAttribute("message"); %>
	
	<div class="container">
  		<h1 align = "center">Login</h1>
  		
	  	<div class="card mx-auto" id = "credentialsSpace">
	   		<div class="card-body">
	    		<form action="./LoginServlet" method = "post">
	
	     		<div class="form-group row">
	      			<label for="username" class="col-sm-3 col-form-label">Username</label>
	      			<div class="col-sm-9">
	      	 			<input type="email" class="form-control" name="username" placeholder="Enter username" value = "customer@gmail.com">
	      			</div>
	     		</div>
	
	     		<div class="form-group row">
	      			<label for="password" class="col-sm-3 col-form-label">Password</label>
	      			<div class="col-sm-9">
	       				<input type="password" class="form-control" name="password" placeholder="Enter password" value = "customer">
	      			</div>
	     		</div>
	
	     		<center>
	     			<button type="submit" class="btn btn-primary">Login</button>
	     		</center>
	    		</form>
	   		</div>
	  	</div>
	  	
	  	<div id = "errorDiv">
			<% if(errorMessage != null) { %>
				<center><h1><%=errorMessage %></h1></center>
			<% } %>
		</div>
	 </div>
	
</body>
</html>