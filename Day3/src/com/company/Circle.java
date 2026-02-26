package com.company;

public class Circle implements Shape {
	private double radius;
	
	public Circle() {
		super();
	}
	

	public Circle(double radius) {
		super();
		this.radius = radius;
	}


	@Override
	public void area() {
		// TODO Auto-generated method stub
		System.out.println(3.14*radius*radius);
		
	}

	@Override
	public void perameter() {
		// TODO Auto-generated method stub
		System.out.println(2*3.14*radius);
		
		
	}
	
	

}
