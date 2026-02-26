package com.company;
//final class can not be extended
//final method can not be overridden
public class Finalcall extends DemoOnFinal {
	@Override
	public void printDetails() {
		System.out.println(Name.toUpperCase());
	}

}
