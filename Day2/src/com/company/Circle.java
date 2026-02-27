package com.coforge;

public class Circle  extends Shape{

	
	double radius;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	@Override
	public void area() {
		System.out.println("Circle Area: "+3.14*this.radius*this.radius);
	}
	
	@Override
	public void circumfrence() {
		System.out.println("Circle Circumfrence: "+2*3.14*radius);
	}
}
