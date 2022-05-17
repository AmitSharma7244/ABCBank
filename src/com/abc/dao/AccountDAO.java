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

import com.abc.bean.Account;
import com.abc.bean.AccountStatus;
import com.abc.util.DBConnectionUtil;

public class AccountDAO {
	
	public boolean createAccount(int customerId, String accountType, double balance) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String createAccount = "insert into Accounts(Customer_Id, Account_type, Balance) value(?, ?, ?)";
			PreparedStatement prepare = connection.prepareStatement(createAccount);
			prepare.setInt(1, customerId);
			prepare.setString(2, accountType);
			prepare.setDouble(3, balance);
			prepare.executeUpdate();
			
			String updateStatus = "insert into accountstatus(Account_Id, Status, Message, LastUpdated) value((select Account_Id from accounts where Customer_Id = ?), ?, ?, ?)";
			String dateTime = LocalDate.now().toString() + " " + LocalTime.now().toString();
			prepare = connection.prepareStatement(updateStatus);
			prepare.setInt(1, customerId);
			prepare.setString(2, "Active");
			prepare.setString(3, "Account created Successfully");
			prepare.setString(4, dateTime);
			prepare.executeUpdate();
			
			prepare.close();
			connection.close();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public Account searchAccountByAccountId(int accountId) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String getAccount = "select * from Accounts where Account_Id = ?";
			PreparedStatement prepare = connection.prepareStatement(getAccount);
			prepare.setInt(1, accountId);
			
			ResultSet result = prepare.executeQuery();
			Account account = null;
			
			while(result.next()) {
				account = new Account(result.getInt("Account_Id"), result.getInt("Customer_Id"), result.getString("Account_type"));
			}
			
			result.close();
			prepare.close();
			connection.close();
			
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Account searchAccountByCustomerId(int customerId) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String getAccount = "select * from Accounts where Customer_Id = ?";
			PreparedStatement prepare = connection.prepareStatement(getAccount);
			prepare.setInt(1, customerId);
			
			ResultSet result = prepare.executeQuery();
			Account account = null;
			
			while(result.next()) {
				account = new Account(result.getInt("Account_Id"), result.getInt("Customer_Id"), result.getString("Account_type"));
			}
			
			result.close();
			prepare.close();
			connection.close();
			
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean deleteAccount(int accountId) {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String deleteAccountStatus = "delete from AccountStatus where Account_Id = ?";
			PreparedStatement prepare = connection.prepareStatement(deleteAccountStatus);
			prepare.setInt(1, accountId);
			prepare.executeUpdate();
			
			String deleteAccount = "delete from Accounts where Account_Id = ?";
			prepare = connection.prepareStatement(deleteAccount);
			prepare.setInt(1, accountId);
			prepare.executeUpdate();
			
			prepare.close();
			connection.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;		
		}
		
	}
	
	public List<AccountStatus> getAccountsStatus() {
		
		Connection connection = DBConnectionUtil.getConnection();
		
		try {
			String getAccountsStatus = "select Accounts.Account_Id, Customer_Id, Status, Message, LastUpdated from Accounts, AccountStatus status where Accounts.Account_Id = status.Account_Id;";
			Statement statement = connection.prepareStatement(getAccountsStatus);
			ResultSet result = statement.executeQuery(getAccountsStatus);
			
			AccountStatus account = null;
			List<AccountStatus> accountsStatus = new ArrayList<AccountStatus>();
			while(result.next()) {
				account = new AccountStatus(result.getInt("Account_Id"), result.getInt("Customer_Id"), result.getString("Status"), result.getString("Message"), result.getString("LastUpdated"));
				accountsStatus.add(account);
			}
			
			statement.close();
			connection.close();
			return accountsStatus;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;		
		}
		
	}
	
}
