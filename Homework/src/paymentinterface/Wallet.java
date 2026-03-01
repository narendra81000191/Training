package paymentinterface;

public class Wallet implements Payment {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("payment done with wallet"+amount);
		
	}

}
