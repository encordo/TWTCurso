package com.mybank.domain;

import com.mybank.exceptions.OverDraftException;

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
	public void withdraw(double amt) throws OverDraftException {
		if(amt <= this.balance + this.overDraftAmount) {
			this.balance -= amt;
		} else {
			throw new OverDraftException("Insufficient funds for overdraft\n", amt - this.balance + this.overDraftAmount);
		}
	}
	
	
	
	
	
}
