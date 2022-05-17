package com.abc.service;

import java.util.List;

import com.abc.bean.Account;
import com.abc.bean.AccountStatus;
import com.abc.dao.AccountDAO;

public class AccountService {
	
	private AccountDAO account = new AccountDAO();
	
	public boolean createAccount(int customerId, String accountType, double balance) {
		return account.createAccount(customerId, accountType, balance);
	}
	
	public Account searchAccountByAccountId(int accountId) {
		return account.searchAccountByAccountId(accountId);
	}
	
	public Account searchAccountByCustomerId(int customerId) {
		return account.searchAccountByCustomerId(customerId);
	}
	
	public boolean deleteAccount(int accountId) {
		return account.deleteAccount(accountId);
	}
	
	public List<AccountStatus> getAccountsStatus() {
		return account.getAccountsStatus();
	}
}
