package arrayi;

public class addelementinfixedarray {
	public static void main(String[] args) {
		int[]arr= {1,2,3,4,5,6,7};
		int position=2;
		int elemetn=25;
		int[]new1=new int[arr.length+1];
		for(int i =0,j=0;i<new1.length;i++) {
			if(i==position)
			{new1[i]=elemetn;
			}else
				{new1[i]=arr[j];
			j++;
			}
		}
	for (int num:new1) {
		System.out.println(num+"");
	}

}}
