package com.company;

public class Outer {
	private String name;
	public void printDetails() {
		this.name="neeku";
		System.out.println("name: "+this.name);
		
	}
	class Inner{
		private String innerName;
		public void printDetails() {
			this.innerName="Amit";
			System.out.println(innerName);
			
		}
		
	}
	public static void main(String[] args) {
		Outer out=new Outer();
		out.printDetails();
		Outer.Inner in=new Outer().new Inner();
		in.printDetails();
	}
	
}