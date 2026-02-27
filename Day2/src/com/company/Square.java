package com.coforge;

public class Square extends Shape {
	
	private int side;

	public Square() {
		super();
	}

	public Square(int side) {
		super();
		this.side = side;
	}
	
	@Override
	public void area() {
		System.out.println(side*side);
	}

}
