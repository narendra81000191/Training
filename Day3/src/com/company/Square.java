package com.company;

public class Square implements Shape {
	private  double side;
	
	

	public Square() {
		super();
	}
	

	public Square(double side) {
		super();
		this.side = side;
	}


	@Override
	public void area() {
		// TODO Auto-generated method stu
		System.out.println(side*side);
		
	}

	@Override
	public void perameter() {
		// TODO Auto-generated method stub
		System.out.println(4*side);
		
	}

}
