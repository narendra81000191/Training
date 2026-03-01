package com.company;
import java.util.Comparator;

public class cityComparator implements Comparator<Customer> {



	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.getCity().compareTo(o2.getCity());
	}

}
