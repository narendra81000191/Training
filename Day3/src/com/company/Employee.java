package com.company;

public class Employee {
	private String name;
	private int id;
	 static  String companyname="coforge";
	 private double salery;
	public Employee() {
		super();
	}
	public Employee(String name, int id,double salery) {
		super();
		this.name = name;
		this.id = id;
		//this.companyname = companyname;
		this.salery=salery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * public String getCompanyname() { return companyname;
	 */
	
	public double getSalery() {
		return salery;
	}
	public void setSalery(double salery) {
		this.salery = salery;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salery=" + salery + "]";
	}
	public void calsalery() {
		double netsel1;

		
		if(this.salery>50000) {
			double hra=0.10;
			double da=0.10;
			 netsel1=salery+salery*hra+salery*da;
			
		}
		else
			
		{
			 netsel1=salery;
	}
		
		System.out.println("netsalery"+netsel1);
		
	
	

}}
