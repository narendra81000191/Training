package manudrivenCrud;

import java.util.HashSet;



public class Read_RetriveData {
static HashSet<Studentdata>empt=new HashSet<Studentdata>();
	
	static {
		
		empt.add(new Studentdata(123,"ashu",67000));
		empt.add(new Studentdata(123,"ashu",67000));
		empt.add(new Studentdata(3,"ashu",67000));
		empt.add(new Studentdata(123,"ashu",67000));
		
	}
public static void main(String[] args) {
	//read operation
	empt.forEach(e->System.out.println(e));

}
}