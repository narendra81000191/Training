package com.coforge;

public class CurrentAccount extends Account{
	
	private double odLimit;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(String accHolderName, long accNum, String branchName, String iFSC, double balance,
			double odLimit) {
		super(accHolderName, accNum, branchName, iFSC, balance);
		this.odLimit = odLimit;
	}
	
	
	@Override
	public void withdraw(double amount) {
		
		if(amount<=0)
			System.out.println("not possible");
		else if(amount>balance+odLimit)
			System.out.println("not possible to withdraw , odLimit exceeded");
		else
			this.balance-=amount;
	}

	@Override
	public String toString() {
		
		return super.toString()+"CurrentAccount [odLimit=" + odLimit + "]";
	}
	
	
	
	
	

}
