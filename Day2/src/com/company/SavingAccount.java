package com.coforge;

public class SavingAccount extends Account{
	private double minBal;

	public SavingAccount() {
		super();
	}

	public SavingAccount(String accHolderName, long accNum, String branchName, String iFSC, double balance,
			double minBal) {
		super(accHolderName, accNum, branchName, iFSC, balance);
		
		this.minBal = minBal;
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount<0)
			System.out.println("not possible");
		else if(this.balance-amount<this.minBal)
			System.out.println("amount withdrawn is more than sa min balance");
		else {
			this.balance-=amount;
			System.out.println("withdraw successful");
		}
	}

	@Override
	public String toString() {
		super.toString();
		return "SavingAccount [minBal=" + minBal + "]";
	}
	
	
	
	

}
