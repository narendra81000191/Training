package com.company.Day4;

import java.util.function.Consumer;

public class Employeemain {
	public static void main(String[] args) {
		Employee empArr[]=new Employee[5];
		Employee e1=new Employee("ashu",123,5664);
		Employee e2=new Employee("rat",123,680);
		Employee e3=new Employee("rat",123,689);
		Employee e4=new Employee("rat",123,687);
		Employee e5=new Employee("rat",123,686);
		Employee emparr[]= {e1,e2,e3,e4,e5};
		for (Employee emp:empArr)
			System.out.println(emp);
		Consumer<Employee[]>empConsumer=(empArr1)->{
			
			double max=empArr1[0].getSalery();
			for (Employee emp:empArr) {
				System.out.println(emp.getName());
				if (emp.getSalery()>max)
					
		};
		empConsumer.accept(empArr);
		
	}

}
