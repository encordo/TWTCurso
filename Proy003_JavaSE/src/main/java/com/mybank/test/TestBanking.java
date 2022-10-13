package com.mybank.test;

import com.mybank.domain.*;
import com.mybank.exceptions.OverDraftException;
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
//		Customer [Simms, Jane] has a checking balance of 200.0 with a 500.00 overdraft protection.
		Bank.addCustomer("Jane", "Simms");
		Bank.getCustomer(0).addAccount(new CheckingAccount(200.0,500.0));
		Bank.addCustomer("Owen", "Bryan");
		Bank.getCustomer(1).addAccount(new SavingsAccount(200.0,1.0));
		try {
	//		Checking Acct [Jane Simms] : withdraw 150.00
			Bank.getCustomer(0).getAccount(0).withdraw(150.0);
	//		Checking Acct [Jane Simms] : deposit 22.50
			Bank.getCustomer(0).getAccount(0).deposit(22.5);
	//		Checking Acct [Jane Simms] : withdraw 147.62
			Bank.getCustomer(0).getAccount(0).withdraw(147.62);
	//		Checking Acct [Jane Simms] : withdraw 470.00
			Bank.getCustomer(0).getAccount(0).withdraw(470.00);
		} catch (OverDraftException ode) {
			System.out.println(ode.getMessage() + ode.getDeficit());
		}
		try {
			
	//		Customer [Bryant, Owen] has a savings balance of 200.0
	//		Savings Acct [Owen Bryant] : withdraw 100.00
			Bank.getCustomer(1).getAccount(0).withdraw(100.0);
	//		Savings Acct [Owen Bryant] : deposit 25.00
			Bank.getCustomer(1).getAccount(0).deposit(25.0);
	//		Savings Acct [Owen Bryant] : withdraw 175.00
			Bank.getCustomer(1).getAccount(0).withdraw(175.0);
	//		Exception: Insufficient funds
	//		Deficit: 50.0	
		} catch (OverDraftException ode) {
			System.out.println(ode.getMessage() + ode.getDeficit());
		}

//		Customer [Bryant, Owen] has a savings balance of 125.0
	}

}
