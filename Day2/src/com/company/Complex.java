package com.coforge;

public class Complex {
	
	double real;
	double imag;
	public Complex() {
		super();
	}
	public Complex(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}
	@Override
	public String toString() {
		return "Complex [real=" + real + ", imag=" + imag + "]";
	}
	
	

}
