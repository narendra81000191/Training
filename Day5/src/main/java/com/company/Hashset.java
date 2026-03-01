package com.company;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Hashset {
	public static void main(String[] args) {
		HashSet <Integer> hashvalue=new HashSet<Integer>();
		hashvalue.add(null);
		hashvalue.add(90);
		hashvalue.add(80);
		hashvalue.add(70);
		System.out.println(hashvalue);
		LinkedHashSet<Integer>lset=new LinkedHashSet<Integer>();
		lset.add(78);
		lset.add(90);
		lset.add(90);
		lset.add(45);
		System.out.println(lset);
		Iterator<Integer> Itr=lset.iterator();
		while(Itr.hasNext())
			System.out.println(Itr.next());
		
		
	}

}
