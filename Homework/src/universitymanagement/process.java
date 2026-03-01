package universitymanagement;

public abstract  class process {
	static final int pass_marks=40;
	final String examcode;
	public process(String examcode) {
		super();
		this.examcode = examcode;
	}
	
	//validate
	void validateStudent(Student s) {
		if(s.attendanceper>=Rules.minattendence)
			System.out.println("eligible for exam");
		else
		{
			System.out.println("not eligle for exam");
	}}
	//allocate hall ticket
	void allocatehallticket(Student s) {
		String hallTicket=Rules.generatetiket();
		System.out.println("hall ticket"+hallTicket);
		
	}
	
	//different for each exam
	abstract void conductexam();
	abstract int evaluate();
	//final method
	final void publishResult(int marks) {
		if(marks>=pass_marks) {
			System.out.println("Result pass");
			
		}
		else {
			System.out.println("result fail");
		}
	}
	//complete workflow 
	final void startExam(Student s) {
		validateStudent(s);
		allocatehallticket(s);
		conductexam();
		int marks=evaluate();
		publishResult(marks);
	}
	
	

}
