package com.mybank.domain;

public class CheckingAccount extends Account {
	//ATRS
	private double overDraftAmount;

	//CNRS
	public CheckingAccount(double initBalance) {
		super(initBalance);
		// TODO Auto-generated constructor stub
		this.overDraftAmount = 300.0;
		
	}
	
	public CheckingAccount(double initBalance, double overDraftAmount) {
		super(initBalance);
		// TODO Auto-generated constructor stub
		this.overDraftAmount = (overDraftAmount < 300.0 ? overDraftAmount:300.0);
		
	}
	
	//METS
	@Override
	public boolean withdraw(double amt) {
		if(amt <= this.balance + this.overDraftAmount) {
			this.balance -= amt;
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
}
