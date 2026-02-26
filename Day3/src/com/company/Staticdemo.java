package com.company;

public class Staticdemo {
	static {
		System.out.println("first");
	
	}
	static {
		System.out.println("second");}
	public void printName(String name) {
		System.out.println(name);
		
	}
	public static void main(String[] args) {
		System.out.println("inside main");
		Staticdemo s=new Staticdemo();
		s.printName("Amit");
	}
	static {
		System.out.println("third")
		;
	}
	static {
		System.out.println("frouth");
	}
	
}
