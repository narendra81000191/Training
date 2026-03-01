package com.company;

import java.util.LinkedList;

public class DemoLInkedlist {
	public static void main(String[] args) {
		LinkedList<Integer>llist=new LinkedList<Integer>();
		llist.add(3);
		llist.add(5);
		llist.add(6);
		System.out.println(llist);
		llist.addFirst(9);
		llist.addLast(8);
		System.out.println(llist);
		System.out.println(llist.hashCode());
		System.out.println(llist.indexOf(5));
		System.out.println(llist.offer(5));
		LinkedList<Integer>clonedLinkedlist= (LinkedList<Integer>)llist.clone();
		System.out.println(clonedLinkedlist);
		System.out.println(clonedLinkedlist.hashCode());
		System.out.println(clonedLinkedlist.peek());
		System.out.println(clonedLinkedlist.poll());
		System.out.println(clonedLinkedlist);
		
	}

}
