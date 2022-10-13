package com.mybank.domain;

import com.mybank.exceptions.OverDraftException;

/**
 * Clase de cuenta bancaria
 * 
 * @author Alumno
 *
 */
public class Account{
	
	protected double balance;
	
	public Account(double initBalance) {
		balance = initBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amt) {
		balance += amt;
	}

	public void withdraw(double amt) throws OverDraftException {
		if(amt <= balance) {
			balance -= amt;
		} else {
			throw new OverDraftException("Insufficient funds.\n", amt - this.balance);
		}
	}
}
