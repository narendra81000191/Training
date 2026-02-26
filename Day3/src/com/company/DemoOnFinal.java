package com.company;

public  class DemoOnFinal {
	protected final String Name ="Ashu";//initialize immediately or initialize while object creation
	public void printDetails() {
		//this.Name="Ashu";
		System.out.println(this.Name);
	}
	public static void main(String[] args) {
		DemoOnFinal dos=new DemoOnFinal();
		dos.printDetails();
		final double  pi=3.14;// final local variable
	}

}
