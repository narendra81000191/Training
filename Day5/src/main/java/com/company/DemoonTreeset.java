package com.company;
import java.lang.Character.Subset;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DemoonTreeset {
	public static void main(String[] args) {
		TreeSet<Student> studentTree=new TreeSet<Student>();
		Student s1=new Student(123,"ashu",90);
		Student s2=new Student(124,"Neeku",91);
		Student s3=new Student(125,"sikha",92);
		Student s4=new Student(126,"Khushi",93);
		Student s5=new Student(127,"Amit",90);
		studentTree.add(s1);
		studentTree.add(s2);
		studentTree.add(s3);
		studentTree.add(s4);
		studentTree.add(s5);
		//System.out.println(studentTree);
	/*	studentTree.forEach(s->System.out.println(s));
		Iterator<Student> itr=studentTree.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		itr=studentTree.descendingIterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		Set<Student>set=studentTree.descendingSet();
		set.forEach(s->System.out.println(s));*/
		Student fromstu=new Student(123,"",0);
		
		Student toStu=new Student(127,"",0);
		Set<Student>subset=studentTree.subSet(fromstu, toStu);
		
		subset.forEach(s->System.out.println(s));
		
		
		
	}

}
