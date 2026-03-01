package universitymanagement;

public class Rules {
	static final String Universitycode="jnt023";
	static final int minattendence=75;
	static int hallticket=10000;
	static String generatetiket() {
		int ticketno=(int) (hallticket*(Math.random()));
		return Universitycode+ticketno;
		
	}

}
