package com.company;

public class PaymentMain {
	public static void main(String[] args) {
		PaymentGateway p=new Cards("Neeku","huafu",90);
		p.pay();
		p.printrecipt();
		PaymentGateway p1=new Wallet("paytem",9890,78);
		p1.pay();
		p1.printrecipt();
		PaymentGateway p2=new Upi("fajkhfa@ayes",797989698);
		p2.pay();
		p2.printrecipt();
	}

}
