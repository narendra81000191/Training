package paymentinterface;

public class Card implements Payment {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("payment done with card"+amount);
		
	}

}
