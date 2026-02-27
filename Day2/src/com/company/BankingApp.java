package com.coforge;

public class BankingApp {

	public static void main(String[] args) {
		SavingAccount sa=new SavingAccount("swapna", 123456, "Gachibowli", "icic0000052", 20000, 5000);
		sa.withdraw(15000);
		
	}

}
