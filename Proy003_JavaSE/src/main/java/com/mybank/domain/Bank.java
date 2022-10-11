package com.mybank.domain;

public class Bank {
	
	public static final int MAX_ACCOUNTS = 10;
	public static final int MAX_CUSTOMERS = 1000;
	
	private static Customer[] customers =  new Customer[MAX_CUSTOMERS];
	private static int numOfCustomers = 0;
	
	private Bank(){
	}
	
	public static void addCustomer(String f, String l){
		//Se busca la primera celda libre y se inserta.
		Bank.customers[Bank.numOfCustomers] = new Customer(f,l,MAX_ACCOUNTS);
		Bank.numOfCustomers++;

	}
	
	public static int getNumOfCustomers() {
		return numOfCustomers;
	}

	public static Customer getCustomer(int index) {
		return customers[index];
	}
}
