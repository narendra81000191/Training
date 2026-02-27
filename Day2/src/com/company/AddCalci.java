package com.coforge;

public class AddCalci {
	
	public int add(int a,int b) {
		return a+b;
	}
	
	public  double add(double d1,double d2) {
		return d1+d2;
	}
	
	public  int add(int a, int b, int c) {
		return a+b+c;
	}
	
	
	public  String add(String s1,String s2) {
		return s1.concat(s2);
	}
	
	
	public  double add(int i1,double d1) {
		return i1+d1;
	}
	
	
	public  double add(double d1,int i1) {
		return d1+i1;
	}
	
	public  Complex add(Complex c1,Complex c2) {
		
		Complex c3=new Complex();
		c3.real=c1.real+c2.real;
		c3.imag=c1.imag+c2.imag;
		return c3;
				
	}
	

}
