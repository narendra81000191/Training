package com.coforge;

public class Main {

	public static void main(String[] args) {
		AddCalci ac=new AddCalci();
		System.out.println( ac.add(3, 4));
		System.out.println( ac.add(5.6, 7.8));
		System.out.println( ac.add(5.6, 3));
		
		Complex c1=new Complex(4, 5);
		Complex c2=new Complex(5,6);
		System.out.println( ac.add(c1, c2));
		System.out.println( ac.add(3, 4.7));
		System.out.println( ac.add("Swapna", " Motupally"));
		
	}

}
