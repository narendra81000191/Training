package paymentinterface;

public class UPI implements Payment{

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("payment done with upi"+amount);
		
	}

}
