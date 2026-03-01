package com.company;

import java.util.Comparator;

public class Deptcomparator implements Comparator<emoployeelinkedlist> {

	@Override
	public int compare(emoployeelinkedlist o1, emoployeelinkedlist o2) {
		// TODO Auto-generated method stub
		return o1.getDept().compareTo(o2.getDept());
	}

}
