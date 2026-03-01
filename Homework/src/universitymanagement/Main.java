package universitymanagement;

public class Main {
public static void main(String[] args) {
	Student s=new Student("fkfakl","Narendra",32);
	process mid=new  midterm();
	System.out.println("midterm");
	mid.startExam(s );
	process lab=new labexam();
	System.out.println("labexam");
	lab.startExam(s);
	
}
}

