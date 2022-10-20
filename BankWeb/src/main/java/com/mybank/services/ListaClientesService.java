package com.mybank.services;

import java.util.ArrayList;
import java.util.List;

import com.mybank.domain.Bank;
import com.mybank.domain.Customer;

public class ListaClientesService {
	
	public List<Customer> getListaClientes(){
		int numClientes = Bank.getNumOfCustomers();
		List<Customer> lc = new ArrayList<Customer>();
		for(int i = 0; i < numClientes; i++) {
			lc.add(Bank.getCustomer(i));
		}
		return lc;
	}

}
