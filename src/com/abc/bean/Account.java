package com.abc.bean;

public class Account {
	
	private int accountId;
	private int customerId;
	private String accountType;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(int customerId, String accountType, double balance) {
		super();
		this.customerId = customerId;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public Account(int accountId, int customerId, String accountType) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountType = accountType;
	}
	
	public Account(int accountId, int customerId, String accountType, double balance) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountType = accountType;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
