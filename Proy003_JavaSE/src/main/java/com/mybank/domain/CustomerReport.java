package com.mybank.domain;

public class CustomerReport {
	
	
	public static void main(String[] args) {
		//Generar el entorno
		Bank.addCustomer("Jane", "Simms");
		Bank.getCustomer(0).addAccount(new SavingsAccount(500.0, SavingsAccount.MIN_INTEREST));
		Bank.getCustomer(0).addAccount(new CheckingAccount(200.0));
		Bank.addCustomer("Owen", "Bryant");
		Bank.getCustomer(1).addAccount(new CheckingAccount(200.0));
		Bank.addCustomer("Tim", "Soley");
		Bank.getCustomer(2).addAccount(new SavingsAccount(1500.0, SavingsAccount.MIN_INTEREST));
		Bank.getCustomer(2).addAccount(new CheckingAccount(200.0));
		Bank.addCustomer("Maria", "Soley");
		Bank.getCustomer(3).addAccount(new CheckingAccount(200.0));
		Bank.getCustomer(3).addAccount(new SavingsAccount(150.0, SavingsAccount.MIN_INTEREST));
		//Mostrar informe.
		System.out.println("CUSTOMERS REPORT\n================");
		//El primer for recorre los clientes del banco
		for(int i = 0; i < Bank.getNumOfCustomers(); i++) {
			Customer cust = Bank.getCustomer(i);
			//Datos del cliente
			System.out.println("Customer: "+ cust.getLastName() + ", " + cust.getFirstName());
			//El segundo las cuenas de cada cliente
			for(int j = 0; j < cust.getNumOfAccounts(); j++) {
				Account acc = cust.getAccount(j);
				//Se identifica el tipo de cuenta.
				if(acc instanceof SavingsAccount) {
					System.out.print("Savings Account: ");
				} else if (acc instanceof CheckingAccount) {
					System.out.print("Checking Account: ");
				} else {
					System.out.print("Regular Account: ");
				}
				//Balance de la cuenta.
				System.out.println("current balance is " + acc.getBalance());
			}
		}
		/*
		 * CUSTOMERS REPORT
================
Customer: Simms, Jane
Savings Account: current balance is 500.0
Checking Account: current balance is 200.0
Customer: Bryant, Owen
Checking Account: current balance is 200.0
Customer: Soley, Tim
Savings Account: current balance is 1500.0
Checking Account: current balance is 200.0
Customer: Soley, Maria
Checking Account: current balance is 200.0
Savings Account: current balance is 150.0
		 */
	}

}
