package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase de cliente bancario
 * 
 * @author Alumno
 *
 */
public class Customer {
	
	private String firstName;
	private String lastName;
	private List<Account> accounts;
	
	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
		this.accounts = new ArrayList<Account>();
	}

	public String getFirstName() {
		return this.firstName;
	}


	public String getLastName() {
		return this.lastName;
	}


	public Account getAccount(int index) {
		return this.accounts.get(index);
	}
	
	public boolean addAccount(Account acc) {
		return this.accounts.add(acc);
		/*
		 * for(int i = 0; i< this.accounts.length; i++) { if(this.accounts[i]==null) {
		 * this.accounts[i] = acc; this.numOfAccounts++; return true; } } return false;
		 */
	}
	
	public int getNumOfAccounts() {
		return this.accounts.size();
	}

}
