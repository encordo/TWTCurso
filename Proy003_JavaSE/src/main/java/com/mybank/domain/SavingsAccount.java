package com.mybank.domain;

public class SavingsAccount extends Account {
	//CONS
	public static final double MIN_INTEREST = 0.5;
	
	//ATRS
	private double interestRate;
	
	public SavingsAccount(double initBalance, double interestRate) {
		super(initBalance);
		// TODO Auto-generated constructor stub
		this.interestRate = interestRate;
	}
	
	public void getProfits() {
		this.balance += (balance * this.interestRate) / 100;
	}
}
