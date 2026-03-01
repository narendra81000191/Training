package arrayi;

public class arraydeletefromgivenposition {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		 int size=5;
		 int position=3;
		 for(int i=position;i<=size;i--) {
			 arr[i]=arr[i+1];}
		 size--;
		 for (int i=0;i<=size;i++) {
			 System.out.println(arr[i]+"");
		 }
		 
	}
	

}
