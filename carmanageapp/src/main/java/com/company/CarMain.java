package com.company;

public class CarMain {
	public static void main(String[] args) {
		Car c1=new Petrocar("fortuner");
		c1.audioSystem();
		c1.engineTyepe();
		c1.showModel();
		Addons.roofopen("fortuner");
		c1.Poll();
		
		Car c2=new Diesalcar("auto");
		c2.audioSystem();
		c2.engineTyepe();
		c2.showModel();
		Addons.roofopen("fortuner");
		Addons.Pollution(89);
		
		
		Car c3= new Gascar("ertiga");
		c3.audioSystem();
		c3.engineTyepe();
		c3.showModel();
		
	}
	


}
