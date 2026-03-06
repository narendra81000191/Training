package cofg.Day6;

public class BankApp {
	public static void main(String[] args) {
		Account acc=new Account(1234,"ashu","ghonda",890);
		acc.withdraw(1000);
		acc.deposit(7900);
		acc.withdraw(1000);
		System.out.println(acc.getBalance());
	}

}
