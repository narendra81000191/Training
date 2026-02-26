package com.company;
import java.util.Scanner;

public class ShapeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Circle c=new Circle(7); c.area(); c.perameter(); Square s =new Square(4);
		 * s.area(); s.perameter();
		 */
		Shape sh = null;
		String type;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the shape");
		type=sc.next();
		if(type.equals("Circle")) {
			int radius=sc.nextInt();
			sh =new Circle(radius);
			sh.area();
			sh.perameter();
		}
		else if(type.equals("Square")) {
			int side=sc.nextInt();
			sh = new Square(side);
			sh.area();
			sh.perameter();
			
			
		}
		else
		{ int side1=sc.nextInt();
		  int side2=sc.nextInt();
		  int side3=sc.nextInt();
		  sh= new Triangle(side1,side2,side3);
		  sh.area();
		  sh.perameter();
			
		}
		
			
		}
		
	}


