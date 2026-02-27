package com.company;

public class Gascar extends Car implements Addons {

	@Override
	public void engineTyepe() {
		// TODO Auto-generated method stub
		System.out.println("it is gas type car");
	}
	public void audioSystem() {System.out.println("has no speaker");
		
	}
	public Gascar(String model) {
		super(model);
	}
	

}
