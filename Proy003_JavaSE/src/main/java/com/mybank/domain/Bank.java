package com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	//public static final int MAX_ACCOUNTS = 10;
	//public static final int MAX_CUSTOMERS = 1000;
	
	private static List<Customer> customers =  new ArrayList<Customer>();
	
	private Bank(){
	}
	
	public static void addCustomer(String f, String l){
		Bank.customers.add(new Customer(f,l));
	}
	
	public static int getNumOfCustomers() {
		return Bank.customers.size();
	}

	public static Customer getCustomer(int index) {
		return Bank.customers.get(index);
	}
}
