package com.company;

public class Customer implements Comparable<Customer> {
	private int cusid;
	private String costumerN;
	private String city;
	private double order;
	
	public Customer(int cusid, String costumerN, String city, double order) {
		super();
		this.cusid = cusid;
		this.costumerN = costumerN;
		this.city = city;
		this.order = order;
	}
	
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public String getCostumerN() {
		return costumerN;
	}
	public void setCostumerN(String costumerN) {
		this.costumerN = costumerN;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getOrder() {
		return order;
	}
	public void setOrder(double order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Customer [cusid=" + cusid + ", costumerN=" + costumerN + ", city=" + city + ", order=" + order + "]";
	}
	//@Override
//	public int compareTo(Customer o) {
//		// TODO Auto-generated method stub
//		return (int)(this.getOrder()-o.getOrder());
//	}
//	

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return this.getCostumerN().compareTo(o.getCostumerN());
	}
	

}
