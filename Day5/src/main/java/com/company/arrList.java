package com.company;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class arrList {
	public static void main(String[] args) {
		ArrayList<Integer> alist=new ArrayList<Integer>();
		alist.add(6);
		alist.add(56);//wrap with wrapper class integer
		
		alist.add(89);
		alist.add(90);
		alist.add(56);
		/*for(int i=0;i<alist.size();i++)
		{
			System.out.println(alist.get(i));
		}
		alist.add(null);
		alist.add(null);
		for(int i=0;i<alist.size();i++)
		System.out.println(alist);
		ArrayList<Integer>intaList=new ArrayList<Integer>();
		intaList.add(89);
		intaList.add(90);
		System.out.println(intaList);
		for(int i=0;i<intaList.size();i++)
			System.out.println(intaList.get(i));
		for(Integer  i:intaList)//enhanced for loop
			System.out.println(i);*/
		//Integer iobj=89;
		//int i1=iobj.intvalue();-----unboxing
		/*
		 * Iterator<Integer>itr=intaList.iterator(); while(itr.hasNext()) { Integer
		 * i=itr.next(); if(i==34) itr.remove(); System.out.println(i); }
		 * System.out.println("+++after iteration===="); System.out.println(itr.next());
		 */
		/*
		 * ListIterator<Integer>listItr=intaList.listIterator();
		 * while(listItr.hasNext()) System.out.println(listItr.next());
		 * 
		 * System.out.println("for ward directin"); System.err.println("reverse direc");
		 * while(listItr.hasPrevious()) System.out.println(listItr.previous());
		 */
		/*
		 * ArrayList<Integer>arrlist=new ArrayList<Ineger>(); arrlist.add(50);
		 * arrlist.add(78); arrlist.add(90);
		 * 
		 */
		ArrayList<Integer>intAlist=new ArrayList<Integer>();
		intAlist.replaceAll(e->e+10);
		System.out.println(intAlist);
		
		intAlist.addFirst(9);
		ArrayList<Integer>clonedArrayList=(ArrayList<Integer>) alist.clone();
		System.out.println(clonedArrayList);
		System.out.println(alist.hashcode());
		System.out.println(clonedArrayList.hashCode());
		clonedArrayList.add(78);
		System.out.println(alist);
		System.out.println(clonedArrayList);
		System.out.println(alist.hashcode());
		System.out.println(clonedArrayList());
		alist.add(67);
		System.out.println(alist);
		System.out.println(clonedArrayList);
		System.out.println(alist.hashCode());
		System.out.println(clonedArrayList.hashCode());
		System.out.println(alist.contains(67));
		alist.containsAll(intAlist);
		alist.forEach(e->System.out.println(e));
		System.out.println(alist.indexOf(98));
		System.out.println(alist.toString().getclass());
		Collection.sort(alist);
		System.out.println(alsit);
	
		
		
	}

}
