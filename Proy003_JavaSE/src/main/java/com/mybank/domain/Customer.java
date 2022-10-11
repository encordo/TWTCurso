package com.mybank.domain;
/**
 * Clase de cliente bancario
 * 
 * @author Alumno
 *
 */
public class Customer {
	
	private String firstName;
	private String lastName;
	private Account[] accounts;
	private int numOfAccounts;
	
	public Customer(String f, String l, int numMaxAccounts) {
		firstName = f;
		lastName = l;
		numOfAccounts = 0;
		accounts = new Account[numMaxAccounts];
	}

	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public Account getAccount(int index) {
		return accounts[index];
	}
	
	public boolean addAccount(Account acc) {
		for(int i = 0; i< this.accounts.length; i++) {
			if(this.accounts[i]==null) {
				this.accounts[i] = acc;
				this.numOfAccounts++;
				return true;
			}
		}
		return false;
	}
	
	public int getNumOfAccounts() {
		return this.numOfAccounts;
	}

}
