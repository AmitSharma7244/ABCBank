package com.abc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.util.DBConnectionUtil;

public class UserDAO {
	
	public boolean validateCredentials(String username, String password) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String getCredentials = "select * from userLogin";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(getCredentials);
			
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
