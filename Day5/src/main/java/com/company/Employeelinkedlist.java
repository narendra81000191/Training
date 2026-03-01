package com.company;
import java.util.LinkedList;

public class Employeelinkedlist {
	public static void main(String[] args) {
			emoployeelinkedlist c1=new emoployeelinkedlist("Ashu",984,799987,"cs","hyd");
			emoployeelinkedlist c2=new emoployeelinkedlist("neeku",983,74987,"it","hyd");
			emoployeelinkedlist c3=new emoployeelinkedlist("niketan",982,721987,"testing","hyd");
			emoployeelinkedlist c4=new emoployeelinkedlist("sikha",981,799677,"hr","hyd");
			emoployeelinkedlist c5=new emoployeelinkedlist("khushi",980,794387,"cs","hyd");
		  LinkedList<emoployeelinkedlist>emplist=new LinkedList<emoployeelinkedlist>();
		  emplist.add(c5);
		  emplist.add(c2);
		  emplist.add(c1);
		  emplist.add(c4);
		  emplist.add(c3);
		  System.out.println(emplist);
		  emplist.sort(new Branchcomparator().thenComparing(new Namecomparator().
				  thenComparing(new Deptcomparator()).thenComparing(new Salerycomparator())));
		  emplist.forEach(emp->System.out.println(emp));
		  
		  
	 
	}

}
