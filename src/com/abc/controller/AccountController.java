package com.abc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.bean.Account;
import com.abc.bean.AccountStatus;
import com.abc.service.AccountService;

@SuppressWarnings("serial")
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String ) request.getSession(false).getAttribute("username");
		
		if(username == null) {
			System.out.println("Session Expired....please login");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else {
			
			String source = request.getParameter("source");
			
			if(source.equals("search")) {
				request.setAttribute("function", "search");
				request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
			}
			else if(source.equals("delete")) {
				request.setAttribute("function", "delete");
				request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
			}
			else if(source.equals("view")) {
				AccountService service = new AccountService();
				List<AccountStatus> accountsStatus = service.getAccountsStatus();
				
				request.setAttribute("accountsStatus", accountsStatus);
				request.getRequestDispatcher("ViewAccountStatus.jsp").forward(request, response);
			}
			else if(source.equals("viewDetails")) {
				AccountService service = new AccountService();
				int accountId = Integer.parseInt(request.getParameter("id"));
				Account account = service.searchAccountByAccountId(accountId);
				
				request.setAttribute("account", account);
				request.getRequestDispatcher("ViewAccountDetails.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button = request.getParameter("button");
		
		if(button.equals("Back")) {
			request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
		}
		else {
			String action = request.getParameter("action");
			
			if(action.equals("create")) {
				createAccount(request, response);
			}
			else if(action.equals("search")) {
				searchAccount(request, response);
			}
			else if(action.equals("delete")) {
				deleteAccount(request, response);
			}
		}
		
	}
	
	private void  createAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String accountType = request.getParameter("accountType");
		double balance = Double.parseDouble(request.getParameter("depositAmount"));
		
		AccountService service = new AccountService();
		
		if(service.createAccount(customerId, accountType, balance)) {
			System.out.println("Account created successfully");
			request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "Unsuccessful");
			request.getRequestDispatcher("CreateAccount.jsp").forward(request, response);
		}
		
	}
	
	private void searchAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchBy = request.getParameter("accountId");
		AccountService service = new AccountService();
		
		Account account = null;
		
		if(!searchBy.isEmpty()) {
			account = service.searchAccountByAccountId(Integer.parseInt(searchBy));
		}
		else {
			searchBy = request.getParameter("customerId");
			account = service.searchAccountByCustomerId(Integer.parseInt(searchBy));
		}
		
		if(account == null) {
			request.setAttribute("message", "No customer found...please enter correct id");
			request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
		}
		else {
			request.setAttribute("account", account);
			
			String function = request.getParameter("function");
			if(function.equals("search"))
				request.getRequestDispatcher("ViewAccountDetails.jsp").forward(request, response);
			else
				request.getRequestDispatcher("DeleteAccount.jsp").forward(request, response);
		}
		
	}
	
	private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		
		AccountService service = new AccountService();
		
		if(service.deleteAccount(accountId)) {
			System.out.println("Account Deleted Successfully");
			request.getRequestDispatcher("CustomerPage2.jsp").forward(request, response);
		}
		else {
			System.out.println("Deletion Unsuccessfull");
			request.getRequestDispatcher("SearchAccount.jsp").forward(request, response);
		}
		
	}

}
