package com.company;

public class Wallet extends PaymentGateway {
	String walletapp;
	int walletid;
	int bachahuapaisa;
	public Wallet() {
		super();
	}
	public Wallet(String walletapp, int walletid, int bachahuapaisa) {
		super();
		this.walletapp = walletapp;
		this.walletid = walletid;
		this.bachahuapaisa = bachahuapaisa;
	}
	public void pay() {
		System.out.println("payment done with wallet");
	}
	
	
	@Override
	public void printrecipt() {
		// TODO Auto-generated method stub
		System.out.println("amount"+amount);
		System.out.println("date"+dateofpayment);
		System.out.println("time");
		
	}

}
