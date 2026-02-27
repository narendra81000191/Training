package com.company;

public class UniversityStu {
	private String Studentid;
	private String name;
	private int Attendanceper;
	public UniversityStu() {
		super();
	}
	public UniversityStu(String studentid, String name,int Attendanceper) {
		super();
		Studentid = studentid;
		this.name = name;
		Attendanceper = Attendanceper;
	}
	
	public String getStudentid() {
		return Studentid;
	}
	public void setStudentid(String studentid) {
		Studentid = studentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttendanceper() {
		return Attendanceper;}
	
	public void setAttendanceper(int attendanceper) {
	Attendanceper = attendanceper;}
	
	@Override
	public String toString() {
		return "UniversityStu [Studentid=" + Studentid + ", name=" + name + ", Attendanceper=" + Attendanceper + "]";
	}
	
	
	

}
