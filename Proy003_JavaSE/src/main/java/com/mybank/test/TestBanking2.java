package com.mybank.test;

import com.mybank.domain.Bank;

public class TestBanking2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Se cargan los clientes
//		Cliente	[1]	es	Simms, Jane
		Bank.addCustomer("Jane", "Simms");
//		Cliente	[2]	es	Bryant, Owen
		Bank.addCustomer("Owen", "Bryant");
//		Cliente	[3]	es	Soley, Tim
		Bank.addCustomer("Tim", "Soley");
//		Cliente	[4]	es	Soley, Maria
		Bank.addCustomer("Maria", "Soley");

		//Se muestra el contenido
		for(int i=0; i < Bank.getNumOfCustomers(); i++) {
			//Se recorre el array para mostrar cada cliente.
			System.out.printf("El Cliente Nº %d es %s %s.%n", i+1, Bank.getCustomer(i).getFirstName(), Bank.getCustomer(i).getLastName());
		}
	}

}
