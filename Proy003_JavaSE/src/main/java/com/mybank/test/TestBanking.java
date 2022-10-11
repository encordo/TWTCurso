package com.mybank.test;

import com.mybank.domain.*;
/**
 * Testing class
 * 
 * @author Alumno
 *
 */

public class TestBanking {
	
	public static void printResult(boolean r) {
		if(r)
			System.out.println("Aceptado");
		else
			System.out.println("Denegado");
	}
	
	public static void main(String[] args) {
		// Creando el cliente Luis Ramos.
		Customer c = new Customer("Luis", "Ramos",Bank.MAX_ACCOUNTS);
		// Creando su cuenta bancario con saldo 500.00. 
		c.addAccount(new Account(500)); // Sacar 150.00: true
		printResult(c.getAccount(0).withdraw(150)); // Ingresar 22.50: true
		printResult(c.getAccount(0).deposit(22.5)); // Sacar 47.62: true
		printResult(c.getAccount(0).withdraw(47.62)); // Sacar 400.00: false
		printResult(c.getAccount(0).withdraw(400)); // Customer [Smith, Jane] tiene un  saldo de 324.88
		System.out.printf("El cliente %s %s tiene un saldo de %.2f €", c.getFirstName(), c.getLastName(), c.getAccount(0).getBalance()); 
	}

}
