package com.abc.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.dao.UserDAO;
import com.abc.util.DBConnectionUtil;


public class LoginService {
	
	UserDAO user = new UserDAO();
	
	Connection connection = DBConnectionUtil.getConnection();
	Statement statement;
	ResultSet result = null;
	
	private void getAdminCredentials() {
		String getCredentials = "select * from admin";
		
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(getCredentials);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getUserCredentials() {
		String getCredentials = "select * from user";
		
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(getCredentials);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getEmployeeCredentials() {
		String getCredentials = "select * from employee";
		
		try {
			statement = connection.createStatement();
			result = statement.executeQuery(getCredentials);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validateCredentials(String username, String password, String role) {
		
		if(role == "admin") {
			getAdminCredentials();
		} else if(role == "user") {
			getUserCredentials();
		} else if(role == "employee") {
			getEmployeeCredentials();
		}
		
		try {
			while(result.next()) {
				if(result.getString("UserName").equals(username)) {
					if(result.getString("Password").equals(password)) {
						return true;
					}
				}
			}
			
			result.close();
			statement.close();
			connection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
}
