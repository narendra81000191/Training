package com.coforge.HibernateMappingPrj;
import java.util.Scanner;
 
import com.coforge.Dao.EmployeeDao;
import com.coforge.entities.Address;
import com.coforge.entities.Employee;
 
public class App {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        EmployeeDao dao = new EmployeeDao();
 
        while(true){
 
            System.out.println("\n==== MENU ====");
            System.out.println("1 Insert Employee");
            System.out.println("2 Get All Employees");
            System.out.println("3 Get Employee By Id");
            System.out.println("4 Update Employee");
            System.out.println("5 Exit");
 
            int choice=sc.nextInt();
 
            switch(choice){
 
                case 1:
 
                    System.out.println("Enter Name");
                    String name=sc.next();
 
                    System.out.println("Enter Email");
                    String email=sc.next();
 
                    System.out.println("Enter Mobile");
                    String mobile=sc.next();
 
                    Address address=new Address("hyd","telangana","56789");
 
                    Employee emp=new Employee(name,email,mobile,address);
 
                    dao.insertEmployee(emp);
 
                    System.out.println("Employee inserted");
                    break;
 
                case 2:
 
                    dao.getAllEmployee().forEach(System.out::println);
                    break;
 
                case 3:
 
                    System.out.println("Enter ID");
 
                    long id=sc.nextLong();
 
                    System.out.println(dao.getEmployeeById(id));
 
                    break;
 
                case 4:
 
                	System.out.println("Enter Employee ID to update:");
                	long id1 = sc.nextLong();
                	 
                	Employee emp1 = dao.getEmployeeById(id1);
                	 
                	if(emp1 != null) {
                	 
                	    System.out.println("Enter new name:");
                	    String name1 = sc.next();
                	 
                	    System.out.println("Enter new email:");
                	    String email1 = sc.next();
                	 
                	    emp1.setEname(name1);
                	    emp1.setEmail(email1);
                	 
                	    dao.updateEmployee(emp1);
                	 
                	    System.out.println("Employee Updated Successfully");
                	}
                	else {
                	 
                	    System.out.println("Employee not found");
                	}
 
                    break;
 
                case 5:
                    System.exit(0);
            }
        }
    }
}