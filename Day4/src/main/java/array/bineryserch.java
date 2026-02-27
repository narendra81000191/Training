package array;
import java.util.Scanner;

public class bineryserch {
	public static void main(String[] args) {
		int arr[]= {2,3,4,5,6,7,8,9};
		Scanner s=new Scanner(System.in);
		int key=s.nextInt();
		int low=0;
		int high=arr.length-1;
		int mid;
		while(low<high) {
			mid=low+high/2;
			if(arr[mid]==key) {
				System.out.println("key found");
				
			}
			else if(key>arr[mid])
				low=mid+1;
			else
				high=mid-1;
		}
		if(low>high)
			System.out.println("notfound");
			
		}
		
		
	

}
