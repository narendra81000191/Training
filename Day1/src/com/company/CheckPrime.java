package com.company;

/**
 * 
 */
public class CheckPrime {
	public static void main(String args[]) {
		int n=27, count=0;
		for( int i=2;i<=n/2;i++)
		if (n%i==0)
			{count++;
		   break;
		
		}
		if (count==0) {System.out.println("no is prime");
	}else 
	{System.out.println("no. is not prime");
	
	}}}