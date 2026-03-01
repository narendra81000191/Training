package com.company;

public class Upi extends PaymentGateway {
	String upiid;
	int mobileno;
	
	

	public Upi() {
		super();
	}
	

	public Upi(String upiid, int mobileno) {
		super();
		this.upiid = upiid;
		this.mobileno = mobileno;
	}


	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("payment done with upi");
		
	}

	@Override
	public void printrecipt() {
		// TODO Auto-generated method stub
		System.out.println("amount"+amount);
		System.out.println("date"+dateofpayment);
		System.out.println("time");
		
	}

}
