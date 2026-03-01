package com.company;

import java.util.Comparator;

public class Salerycomparator implements Comparator<emoployeelinkedlist> {

	@Override
	public int compare(emoployeelinkedlist o1, emoployeelinkedlist o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getSalery()-o2.getSalery());
	}

}
