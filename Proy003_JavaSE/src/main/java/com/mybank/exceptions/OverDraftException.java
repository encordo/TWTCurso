package com.mybank.exceptions;

public class OverDraftException extends Exception {

	private double deficit;
	//private static final long serialVersionUID = 1L;
	public OverDraftException(String msg, double deficit) {
		super(msg);
		this.deficit = deficit;
	}
	public double getDeficit() {
		return deficit;
	}

	
}
