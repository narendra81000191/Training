package com.company;

public abstract class PaymentGateway {
	double amount;
	String dateofpayment;
	public PaymentGateway() {
		super();
	}
	public PaymentGateway(double amount, String dateofpayment) {
		super();
		this.amount = amount;
		this.dateofpayment = dateofpayment;
	}
	public abstract void pay();
	public abstract void printrecipt();
	{System.out.println(amount);
	System.out.println(dateofpayment);
	}
		
	
		
	
	

}
