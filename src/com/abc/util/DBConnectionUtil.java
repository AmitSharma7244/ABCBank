package com.abc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private static final String url = "jdbc:mysql://localhost:3306/abcbank?useSSL=false";
	private static final String user = "root";
	private static final String password = "root";
	
	public static void main(String[] args) {
		Connection connection = getConnection();
		
		java.sql.Statement stmt;
		try {
			stmt = connection.createStatement();
			java.sql.ResultSet res = stmt.executeQuery("select * from userLogin");
			
			while(res.next()) {
				System.out.println(res.getString("UserName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
}
