package com.company;

public interface Addons {
	public default  void audioSystem() {
		System.out.println("Audio system wiht high base");
		System.out.println("specker wiht brand boss");
	}
	public static  void roofopen(String model) {
		System.out.println("roof open feater will updatein "+model);
	}
	public static void Pollution(int years) {
		System.out.println("pollutionn expired in"+years
				);
	}

}
