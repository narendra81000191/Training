package com.company;
import java.util.Comparator;

public class OrdercostComparator implements Comparator<Customer> {



	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return  (int)(o1.getOrder()-o2.getOrder());
	}

}
