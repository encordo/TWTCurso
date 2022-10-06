package com.mybank.domain;

public class Bank {
	
	private Customer[] customers;
	private int numOfCustomers;
	
	public Bank(int size){
		this.numOfCustomers=0;
		this.customers = new Customer[size];
	}
	
	public void addCustomer(String f, String l){
		//Se busca la primera celda libre y se inserta.
		this.customers[this.numOfCustomers] = new Customer(f,l);
		this.numOfCustomers++;

	}
	
	public int getNumOfCustomers() {
		return numOfCustomers;
	}

	public Customer getCustomer(int index) {
		return customers[index];
	}
}
