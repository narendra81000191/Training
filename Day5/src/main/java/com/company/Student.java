package com.company;

import java.util.Comparator;

public class Student implements Comparable<Student> {
	private int  studentid;
	private String sName;
	private int Marks;
	public Student() {
		super();
	}
	public Student(int studentid, String sName, int marks) {
		super();
		this.studentid = studentid;
		this.sName = sName;
		Marks = marks;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int marks) {
		Marks = marks;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", sName=" + sName + ", Marks=" + Marks + "]";
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.studentid-o.studentid;
	}
	

}
