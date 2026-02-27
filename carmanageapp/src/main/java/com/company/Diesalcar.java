package com.company;

public class Diesalcar extends Car  {

	@Override
	public void engineTyepe() {
		// TODO Auto-generated method stub
		System.out.println("it is the deisal car");
		
	}
	public void audioSystem() {
		System.out.println("it has high base speaker");
		
	}
	public Diesalcar(String model) {
		super(model);
	}
	

}
