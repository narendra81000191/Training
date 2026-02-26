package com.company;

public class EmpMain {
	public static void main(String[] args) {
		Employee e1=new Employee("ashu",123,890000);
		Employee e2=new Employee("neeku",123,900000);
		Employee e3=new Employee("niketan",123,780000);
		Employee.companyname="Deloitte";
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		e1.calsalery();
		e2.calsalery();
		e3.calsalery();
		
	}

}
