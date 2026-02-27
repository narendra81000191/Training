package com.coforge;

public class ShapesMain {

	public static void main(String[] args) {
		Circle c1=new Circle(3.14);
		c1.area();
		c1.circumfrence();
		
		System.out.println(c1 instanceof Circle);
		System.out.println(c1 instanceof Shape);
		System.out.println(c1 instanceof Object);
		
		Shape sh=new Shape();
		sh=new Circle(7);
		sh.area();
		sh=new Square(5);
		sh.area();
		
		
		//Shape sh=new Shape();
	}

}
