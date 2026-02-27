package com.company.Day4;

public class Employee {
	
	private String name;
	private int eid;
	private double salery;
	public Employee() {
		super();
	}
	public Employee(String name, int eid, double salery) {
		super();
		this.name = name;
		this.eid = eid;
		this.salery = salery;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public double getSalery() {
		return salery;
	}
	public void setSalery(double salery) {
		this.salery = salery;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", salery=" + salery + "]";
	}
	

}
