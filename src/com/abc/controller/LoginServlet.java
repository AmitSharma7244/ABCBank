package com.abc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.abc.service.LoginService;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService service = new LoginService();
		
		if(service.validateCredentials(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "Invalid Credentials");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}
}
