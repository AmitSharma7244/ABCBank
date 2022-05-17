package com.abc.service;

import java.util.List;

import com.abc.bean.Customer;
import com.abc.dao.CustomerDAO;

public class CustomerService {
	
	private static CustomerDAO customerDao = new CustomerDAO();
	
	public boolean addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}
	
	public List<Customer> getListOfCustomers() {
		return customerDao.getListOfCustomers();
	}
	
	public Customer searchCustomerBySSNId(int customerSSN) {
		return customerDao.searchCustomerBySSNId(customerSSN);
	}
	
	public Customer searchCustomerByCustomerId(int customerId) {
		return customerDao.searchCustomerByCustomerId(customerId);
	}
	
	public boolean updateCustomerInfo(int customerSSN, String newName, int newAge, String newAddress, String newState, String newCity) {
		return customerDao.updateCustomerInfo(customerSSN, newName, newAge, newAddress, newState, newCity);
	}
	
	public boolean deleteCustomer(int customerSSN) {
		return customerDao.deleteCustomer(customerSSN);
	}
	
}
