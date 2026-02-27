package array;
import java.util.Scanner;
public class linearserch {
	public static void main(String[] args) {
		int arr[]= {2,3,4,5,6,7,8};
		Scanner sc=new Scanner(System.in);
		int key=sc.nextInt();
		int i=0;
		for(;i<=arr.length;i++)
			if(arr[i]==key)
			{System.out.println("key found");
		
	}
		if(i==arr.length)
		{
			System.out.println("not found");
		}

}}
