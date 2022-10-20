package com.mybank.services;

import java.util.ArrayList;
import java.util.List;

import com.mybank.domain.Account;
import com.mybank.domain.Bank;

public class CuentasClienteService {

	public List<Account> getCuentasCliente(int idCliente){
		List<Account> la = new ArrayList<Account>();
		int numCuentas = Bank.getCustomer(idCliente).getNumOfAccounts();
		for(int i = 0; i < numCuentas;i++) {
			la.add(Bank.getCustomer(idCliente).getAccount(i)) ;
		}
		return la;
	}
}
