package cofg.Day6;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static HashSet<Employee>empt=new HashSet<Employee>();
	
	static {
		
		empt.add(new Employee(123,"ashu",67000));
		empt.add(new Employee(123,"ashu",67000));
		empt.add(new Employee(123,"ashu",67000));
		empt.add(new Employee(123,"ashu",67000));
		
	}
public static void main(String[] args) {
	//read operation
	empt.forEach(e->System.out.println(e));
	// ccreate or insert
	Scanner sc =new Scanner(System.in);
	System.out.println("enter detualse empid,empName,salary");
	Employee emp=new Employee(sc.nextLong(),sc.next(),sc.nextDouble());
	empt.add(emp);
	//update
	System.out.println("enter emplyoyee id for updaton");
	long id = sc.nextLong();
	
}

}
