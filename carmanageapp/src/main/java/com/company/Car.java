package com.company;
//concreate method we use the abstract class


public abstract class Car implements Addons {
	private String model;

	public Car() {
		super();
	}

	public Car(String model) {
		super();
		this.model = model;
	}
	public abstract void engineTyepe();
	public void showModel() {
		System.out.println("Model"+this.model);
	}
	public  static void Poll() {
		Addons.Pollution(3);
	}

}
