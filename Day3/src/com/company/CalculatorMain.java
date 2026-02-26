package com.company;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator c=new Calculator();
		System.out.println(c.add(5, 6));
		System.out.println(c.sub(8, 9));
		System.out.println(c.mul(7,9 ));
		c.div(8,9);
		c.power(2, 4);
		c.squareRoot(9);
		c.logValue(10);
		

	}

}
