package com.company.Day4;
import java.util.Scanner;

public class DemoArray {
	public static void main(String[] args) {
		int arr[]=new int[5];
		Scanner s =new Scanner(System.in);
		System.out.println("enter the element");
		int sum=0;
		for(int i = 0;i<arr.length;i++) {
			arr[i]=s.nextInt();
			sum+=arr[i];
	}
		System.out.println("sum"+sum);
		//System.out.println("even Elements");
		//for(int i =0;i<arr.length;i++) {
			//if (arr[i]%2==0)
			//System.out.println(arr[i]);
		
			
		
		
		
	}
	System.out.println("sum"+sum);

}
