package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.abc.bean.Customer;
import com.abc.util.DBConnectionUtil;

public class CustomerDAO {
	
	public boolean addCustomer(Customer customer) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			
			String addCustomers = "insert into Customers(Customer_ssnId, Customer_name, Customer_age, Customer_address, Customer_state, Customer_city) value(?,?,?,?,?,?)";
			PreparedStatement prepare = connection.prepareStatement(addCustomers);
			prepare.setInt(1, customer.getCustomerSSN());
			prepare.setString(2, customer.getCustomerName());
			prepare.setInt(3, customer.getAge());
			prepare.setString(4, customer.getAddress());
			prepare.setString(5, customer.getState());
			prepare.setString(6, customer.getCity());
			prepare.executeUpdate();
			
			String addStatus = "insert into customerstatus(Customer_ssnId, Status, Message, LastUpdated) value (?, ?, ?, ?)";
			String dateTime = LocalDate.now().toString() + " " + LocalTime.now().toString();
			prepare = connection.prepareStatement(addStatus);
			prepare.setInt(1, customer.getCustomerSSN());
			prepare.setString(2, "Active");
			prepare.setString(3, "Customer created successfully");
			prepare.setString(4, dateTime);
			prepare.executeUpdate();
			
			prepare.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Customer> getListOfCustomers() {
		
		List<Customer> customerList = null;
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			
			String getCustomers = "select customers.Customer_Id, customers.Customer_ssnId, Status, Message, LastUpdated from Customers, CustomerStatus status where Customers.Customer_ssnId = status.Customer_ssnId order by Customers.Customer_Id";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(getCustomers);
			
			customerList = new ArrayList<Customer>();
			Customer customer;
			
			while(result.next()) {
				customer = new Customer(result.getInt("Customer_Id"), result.getInt("Customer_ssnId"), result.getString("Status"), result.getString("Message"), result.getString("LastUpdated"));
				customerList.add(customer);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return customerList;
	}
	
	public Customer searchCustomerBySSNId(int customerSSN) {
		
		Customer customer = null;
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String getCustomer = "select * from Customers where Customer_ssnId = ?";
			PreparedStatement prepare = connection.prepareStatement(getCustomer);
			prepare.setInt(1, customerSSN);
			ResultSet result = prepare.executeQuery();
			
			if(result.next()) {
				customer = new Customer(result.getInt("Customer_Id"), result.getInt("Customer_ssnId"), result.getString("Customer_name"), result.getInt("Customer_age"), result.getString("Customer_address"), result.getString("Customer_state"), result.getString("Customer_city"));
				result.close();
				prepare.close();
				connection.close();
				return customer;
			}
			else {
				result.close();
				prepare.close();
				connection.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Customer searchCustomerByCustomerId(int customerId) {
		
		Customer customer = null;
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String getCustomer = "select * from Customers where Customer_Id = ?";
			PreparedStatement prepare = connection.prepareStatement(getCustomer);
			prepare.setInt(1, customerId);
			ResultSet result = prepare.executeQuery();
			
			if(result.next()) {
				customer = new Customer(result.getInt("Customer_Id"), result.getInt("Customer_ssnId"), result.getString("Customer_name"), result.getInt("Customer_age"), result.getString("Customer_address"), result.getString("Customer_state"), result.getString("Customer_city"));
				result.close();
				prepare.close();
				connection.close();
				return customer;
			}
			else {
				result.close();
				prepare.close();
				connection.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateCustomerInfo(int customerSSN, String newName, int newAge, String newAddress, String newState, String newCity) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			
			String updateInfo = "update Customers set Customer_name = ?, Customer_age = ?, Customer_address = ?, Customer_state = ?, Customer_city = ? where Customer_ssnId = ?";
			PreparedStatement prepare = connection.prepareStatement(updateInfo);
			prepare.setString(1, newName);
			prepare.setInt(2, newAge);
			prepare.setString(3, newAddress);
			prepare.setString(4, newState);
			prepare.setString(5, newCity);
			prepare.setInt(6, customerSSN);
			prepare.executeUpdate();
			
			String updateStatus = "update CustomerStatus set Message = ?, LastUpdated = ? where Customer_ssnId = ?";
			String dateTime = LocalDate.now().toString() + " " + LocalTime.now().toString();
			prepare = connection.prepareStatement(updateStatus);
			prepare.setString(1, "Customer Updated Successfully");
			prepare.setString(2, dateTime);
			prepare.setInt(3, customerSSN);
			prepare.executeUpdate();
			
			prepare.close();
			connection.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean deleteCustomer(int customerSSN) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String deleteStatus = "delete from CustomerStatus where Customer_ssnId = ?";
			PreparedStatement prepare = connection.prepareStatement(deleteStatus);
			prepare.setInt(1, customerSSN);
			prepare.executeUpdate();
			
			String deleteCustomer = "delete from Customers where Customer_ssnId = ?";
			prepare = connection.prepareStatement(deleteCustomer);
			prepare.setInt(1, customerSSN);
			prepare.executeUpdate();
			
			prepare.close();
			connection.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
