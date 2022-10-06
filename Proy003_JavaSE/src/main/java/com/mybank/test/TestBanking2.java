package com.mybank.test;

import com.mybank.domain.Bank;

public class TestBanking2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank(4);
		//Se cargan los clientes
//		Cliente	[1]	es	Simms, Jane
		bank.addCustomer("Jane", "Simms");
//		Cliente	[2]	es	Bryant, Owen
		bank.addCustomer("Owen", "Bryant");
//		Cliente	[3]	es	Soley, Tim
		bank.addCustomer("Tim", "Soley");
//		Cliente	[4]	es	Soley, Maria
		bank.addCustomer("Maria", "Soley");

		//Se muestra el contenido
		for(int i=0; i < bank.getNumOfCustomers(); i++) {
			//Se recorre el array para mostrar cada cliente.
			System.out.printf("El Cliente Nº %d es %s %s.%n", i+1, bank.getCustomer(i).getFirstName(), bank.getCustomer(i).getLastName());
		}
	}

}
