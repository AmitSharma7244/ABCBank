<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="CustomerPage2.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	
	<div class="header">
		<nav class="navbar navbar-light">
  			<span class="navbar-brand">ABC Bank</span>
		</nav>
		
		<nav class="navbar navbar-expand-sm bg-dark" id="menu">
			<div class="container">
				<ul class="nav navbar-nav">
					<li class="nav-item">
						<a class = "nav-link" href = "CustomerPage.jsp">Home</a>
					</li>
					<li class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle" id="Dropdown" data-toggle="dropdown">Customer Management</a>
							<div class="dropdown-menu" aria-labelledby="Dropdown">
								<ul>
									<li class="dropdown-item">
										<a class = "nav-link" href = "AddCustomer.jsp">Add Customer</a>
									</li>
									<li class="dropdown-item">
										<a class = "nav-link" href = "./CustomerController?source=view">View Customer Status</a>
									</li>
									<li class="dropdown-item">
										<a class = "nav-link" href = "./CustomerController?source=search">Search Customer</a>
									</li>
									<li class="dropdown-item">
										<a class = "nav-link" href = "./CustomerController?source=update">Update Customer</a>
									</li>
									<li class="dropdown-item">
										<a class = "nav-link" href = "./CustomerController?source=delete">Delete Customer</a>
									</li>
								</ul>
							</div>
					</li>
					<li class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle" id="Dropdown" data-toggle="dropdown">Account Management</a>
							<div class="dropdown-menu" aria-labelledby="Dropdown">
								<ul>
									<li class="dropdown-item">
										<a class = "nav-link" href = "CreateAccount.jsp">Create Account</a>
									</li>
									<li class="dropdown-item">
										<a class = "nav-link" href = "./AccountController?source=view">View Account Status</a>
									</li>
									<li class="dropdown-item">
										<a class = "nav-link" href = "./AccountController?source=search">Search Account</a>
									</li>
									<li class="dropdown-item">
										<a class = "nav-link" href = "./AccountController?source=delete">Delete Account</a>
									</li>
								</ul>
							</div>
					</li>
				</ul>
				
				<ul class="nav navbar-nav mr-right">
					<li class="nav-item">
						<a class = "nav-link" href = "LoginPage.jsp">Logout</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
	
	<!-- First include JQuery file -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>

	<!-- Then for normal dropdowns include popper.js file -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	
	<!-- Then include bootstrap.min.js / bootstrap.js file -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	
</body>
</html>