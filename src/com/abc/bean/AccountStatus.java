package com.abc.bean;

public class AccountStatus {
	
	private int accountId;
	private int customerId;
	private String status;
	private String message;
	private String lastUpdated;
	
	public AccountStatus() {
		
	}
	
	public AccountStatus(int accountId, int customerId, String status, String message, String lastUpdated) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.status = status;
		this.message = message;
		this.lastUpdated = lastUpdated;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
