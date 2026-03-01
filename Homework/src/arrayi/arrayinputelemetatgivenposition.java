package arrayi;

public class arrayinputelemetatgivenposition {
	public static void main(String[] args) {
		int[] arr=new int[10];
		 arr[0]=1;
		 arr[1]=2;
		 arr[2]=3;
		 arr[3]=4;
		 int size=4;
		 int position=3;
		 int element=5;
		 if(size>=arr.length) {
			 System.out.println("array is full");
		 return;}
		 
		if(position<0||position>size)
	   {System.out.println("invalid postion");
return;
}
		for (int i=size-1;i>=position;i--) {
			arr[i+1]=arr[i];
		}
		arr[position]=element;
		size++;
		for(int i=0;i<=size;i++) {
			System.out.println(arr[i]+"");}
			
	}
}
