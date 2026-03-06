package cofg.Day6;

public class DemoClass {
	public static void calculate() {
		int a=5,b=4;
		if(b==0)
			throw new ArithmeticException();
		else
			System.out.println(a/b);
		
	}
	public static void Agecal(int a) throws AgerelatedException{
		if(a>15)
			System.out.println("eligible to register plus two");
		else
			throw new AgerelatedException();
			}
	public static void main(String[] args) throws AgerelatedException {
		try { 
			calculate();
			}
		
		catch(ArithmeticException e) {
				e.printStackTrace();
				
			}
		try {
			Agecal(17);
		}
		finally {
			System.out.println("aapplication completed");
		}
		}
		
	}
