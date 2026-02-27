package com.company;

public class Petrocar extends Car implements Addons {

	@Override
	public void engineTyepe() {
		// TODO Auto-generated method stub
		System.out.println("it's the petrol variant");
		
	}
	public void audioSystem() {
		System.out.println("Audio system is wiht 6 speaker , woofer , v8 engine");
	}
	public Petrocar(String model) {
		super(model);
	}
	
	

}
