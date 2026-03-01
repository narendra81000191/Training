package com.company;
import java.util.ArrayList;
import java.util.Collections;


public class coustumerArray {
	public static void main(String[] args) {
		Customer c1=new Customer(1,"ashu","delhi",799987);
				Customer c2=new Customer(1,"neeku","delhi",78000);
	           Customer c3=new Customer(1,"nitin","delhi",78000);
			Customer c4=new Customer(1,"sikha","delhi",78000);
					Customer c5=new Customer(1,"harsh","delhi",78000);
					ArrayList<Customer> cuslist=new ArrayList<Customer>();
					cuslist.add(c1);
					cuslist.add(c2);
					cuslist.add(c3);
					cuslist.add(c4);
					cuslist.add(c5);
					cuslist.sort(new OrdercostComparator().thenComparing(new cityComparator()));
					cuslist.forEach(cust->System.out.println(cust));
					
}}
