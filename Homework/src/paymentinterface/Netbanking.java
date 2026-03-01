package paymentinterface;

public class Netbanking implements Payment{

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("payment done Netbanking"+amount);
		
	}

}
