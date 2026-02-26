package com.company;

public class Triangle implements Shape {
	private int side1;
	private int side2;
	private int side3;
	public Triangle() {
		super();
	}
	public Triangle(int side1, int side2, int side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	@Override
	public void area() {
		int semiperimeter=(side1+side2+side3)/2;
		double area= Math.sqrt(semiperimeter*(semiperimeter-side1)*(semiperimeter-side2)*(semiperimeter-side3));
		System.out.println(area);
		
		
		// TODO Auto-generated method stub
		
	}
	@Override
	public void perameter() {
		// TODO Auto-generated method stub
		System.out.println(side1+side2+side3);
		
	}
	
	

}
