package com.mybank.domain;
/**
 * Clase de cuenta bancaria
 * 
 * @author Alumno
 *
 */
public class Account {
	
	protected double balance;
	
	public Account(double initBalance) {
		balance = initBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amt) {
		balance += amt;
		return true;
	}

	public boolean withdraw(double amt) {
		if(amt <= balance) {
			balance -= amt;
			return true;
		} else {
			return false;
		}
	}
}
