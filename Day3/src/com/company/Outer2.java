package com.company;

;

public  class Outer2 {
		private String name;
		public void printDetails() {
			this.name="neeku";
			System.out.println("name: "+this.name);
			
		}
		static class Inner{
			private String innerName;
			public void printDetails() {
				this.innerName="Amit";
				System.out.println(innerName);
				
			}
			
		}
		public static void main(String[] args) {
			/*Outer out=new Outer();
			out.printDetails();
			Outer.Inner in=new Outer().new Inner();
			in.printDetails();*/
			Outer2.name="Neeku";
			Outer2.printDetails();
			inner.printDetailsofInnerName();
		}
		
	}

}
