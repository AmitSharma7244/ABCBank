package com.abc.bean;

public class Customer {
	
	private int customerId;
	private int customerSSN;
	private String customerName;
	private int age;
	private String address;
	private String state;
	private String city;
	
	private String status;
	private String message;
	private String lastUpdated;
	
	public Customer() {
		
	}
	
	public Customer(int customerId, int customerSSN, String status, String message, String lastUpdated) {
		super();
		this.customerId = customerId;
		this.customerSSN = customerSSN;
		this.status = status;
		this.message = message;
		this.lastUpdated = lastUpdated;
	}
	
	public Customer(int customerSSN, String customerName, int age, String address, String state, String city) {
		super();
		this.customerSSN = customerSSN;
		this.customerName = customerName;
		this.age = age;
		this.address = address;
		this.state = state;
		this.city = city;
	}
	
	public Customer(int customerId, int customerSSN, String customerName, int age, String address, String state, String city) {
		super();
		this.customerId = customerId;
		this.customerSSN = customerSSN;
		this.customerName = customerName;
		this.age = age;
		this.address = address;
		this.state = state;
		this.city = city;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerSSN() {
		return customerSSN;
	}

	public void setCustomerSSN(int customerSSN) {
		this.customerSSN = customerSSN;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
