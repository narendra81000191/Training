package com.company.Day4;
//where the method not neeeded to implement in every class we use 
//default function

public interface MyInterface {
public void display();
public  default void printDetails() {
	System.out.println("default method of Myinterface invoked");
	
}
public static void parkingArea(String compName) {
	System.out.println("using parking name "+compName); 
		
	
}
}
