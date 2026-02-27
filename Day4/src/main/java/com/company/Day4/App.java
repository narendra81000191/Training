package com.company.Day4;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	MyInterface mi=new DemoClass();
    	mi.printDetails();
        mi= new Hello();
    	mi.display();
        System.out.println("Hello World!");
        
    }
}
