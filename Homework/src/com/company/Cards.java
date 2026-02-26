package com.company;

public class Cards extends PaymentGateway {
	public String cardname;
	public String cardid;
	public int cvv;
	
	

	public Cards() {
		super();
	}
	

	public Cards(String cardname, String cardid, int cvv) {
		super();
		this.cardname = cardname;
		this.cardid = cardid;
		this.cvv = cvv;
	}
	


	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("payment done with card");
		
	}

	@Override
	public void printrecipt() {
		// TODO Auto-generated method stub
		System.out.println("amount"+amount);
		System.out.println("date"+dateofpayment);
		System.out.println("time");
		
	}

}
