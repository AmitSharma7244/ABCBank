package com.abc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.bean.Customer;
import com.abc.service.CustomerService;

@SuppressWarnings("serial")
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String) request.getSession(false).getAttribute("username");
		
		if(username == null) {
			System.out.println("Session Expired....please login");
			request.getRequestDispatcher("SessionExpired.jsp").forward(request, response);
		}
		else {
			String source = request.getParameter("source").toLowerCase();
			
			if(source.equals("add")) {
				request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
			}
			else if(source.equals("view")) {
				CustomerService service = new CustomerService();
				
				List<Customer> customerList = service.getListOfCustomers();
				
				request.setAttribute("customerList", customerList);
				request.getRequestDispatcher("ViewCustomersStatus.jsp").forward(request, response);
			}
			else if(source.equals("viewdetails")) {
				String id = request.getParameter("id");
				CustomerService service = new CustomerService();
				Customer customer = service.searchCustomerByCustomerId(Integer.parseInt(id));

				request.setAttribute("customer", customer);
				request.getRequestDispatcher("ViewCustomerDetails.jsp").forward(request, response);
			}
			else if(source.equals("search")) {
				request.setAttribute("function", "search");
				request.getRequestDispatcher("SearchCustomer.jsp").forward(request, response);
			}
			else if(source.equals("update")) {
				
				String id = request.getParameter("id");
				
				if(id != null) {
					CustomerService service = new CustomerService();
					Customer customer = service.searchCustomerByCustomerId(Integer.parseInt(id));

					request.setAttribute("customer", customer);
					request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
				}
				else {
					request.setAttribute("function", "update");
					request.getRequestDispatcher("SearchCustomer.jsp").forward(request, response);
				}
			}	
			else if(source.equals("delete")) {
				String id = request.getParameter("id");
				
				if(id != null) {
					CustomerService service = new CustomerService();
					Customer customer = service.searchCustomerByCustomerId(Integer.parseInt(id));

					request.setAttribute("customer", customer);
					request.getRequestDispatcher("DeleteCustomer.jsp").forward(request, response);
				}
				else {
					request.setAttribute("function", "delete");
					request.getRequestDispatcher("SearchCustomer.jsp").forward(request, response);
				}
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String) request.getSession(false).getAttribute("username");		
		
		if(username == null) {
			System.out.println("Session Expired....please Login");
		}
		else {
			String button = request.getParameter("button");
			
			if(button.equals("Back")) {
				request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
			}
			else {
				
				String action = request.getParameter("action");
				
				if(action.equals("add")) {
					addCustomer(request, response);			
				}
				else if(action.equals("search")) {
					searchCustomer(request, response);
				}
				else if(action.equals("update")) {
					updateCustomer(request, response);
				}
				else if(action.equals("delete")) {
					deleteCustomer(request, response);
				}
			}
		}
	}
	
	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Customer customer = new Customer(Integer.parseInt(request.getParameter("customerSSN")), request.getParameter("customerName"), Integer.parseInt(request.getParameter("age")), request.getParameter("address"), request.getParameter("state"), request.getParameter("city"));
		
		CustomerService service = new CustomerService();
			
		if(service.addCustomer(customer)) {
			System.out.println("Added Successfully");
			request.setAttribute("message", "Customer Added Successfully");
			request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
		}
		else {
			System.out.println("Unsuccessful");
			request.setAttribute("message", "Unsuccessful");
			request.getRequestDispatcher("AddCustomer.jsp").forward(request, response);
		}
	}
	
	private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchBy = request.getParameter("customerSSN");
		CustomerService service = new CustomerService();
		
		Customer customer = null;
		
		if(!searchBy.isEmpty()) {
			customer = service.searchCustomerBySSNId(Integer.parseInt(searchBy));
		}
		else {
			searchBy = request.getParameter("customerId");
			customer = service.searchCustomerByCustomerId(Integer.parseInt(searchBy));
		}
		
		if(customer == null) {
			request.setAttribute("message", "No customer found...please enter correct id");
			request.getRequestDispatcher("SearchCustomer.jsp").forward(request, response);
		}
		else {
			String function = request.getParameter("function");
			
			if(function.equals("search")) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("ViewCustomerDetails.jsp").forward(request, response);
			}
			else if(function.equals("update")) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
			}
			else if(function.equals("delete")) {
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("DeleteCustomer.jsp").forward(request, response);
			}
		}
	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerSSN = Integer.parseInt(request.getParameter("customerSSN"));
		String newName = request.getParameter("newName");
		int newAge = Integer.parseInt(request.getParameter("newAge"));
		String newAddress = request.getParameter("newAddress");
		String newState = request.getParameter("newState");
		String newCity = request.getParameter("newCity");
		
		CustomerService service = new CustomerService();
		if(service.updateCustomerInfo(customerSSN, newName, newAge, newAddress, newState, newCity)) {
			request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
			System.out.println("Updated successfully");
		}
		else {
			request.setAttribute("message", "Update unsuccessful");
			request.getRequestDispatcher("UpdateCustomer.jsp").forward(request, response);
			System.out.println("Unsuccessful");
		}
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerSSN = Integer.parseInt(request.getParameter("customerSSN"));
		
		CustomerService service = new CustomerService();
		if(service.deleteCustomer(customerSSN)) {
			request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
			System.out.println("Deleted successfully");
		}
		else {
			request.getRequestDispatcher("DeleteCustomer.jsp").forward(request, response);
			request.setAttribute("message", "Unable to delete");
		}
	}
	
}
