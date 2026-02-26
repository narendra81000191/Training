package com.company;

public class Student {
	private String name;
	private int Sid;
	public Student() {
		super();
	}
	public Student(String name, int sid) {
		super();
		this.name = name;
		Sid = sid;}
	private static collegeAdd address;
	
	
	public static collegeAdd getAddress() {
		return address;
	}
	public static void setAddress(collegeAdd address) {
		Student.address = address;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", Sid=" + Sid + "Address"+address+"]";
	}


	static class collegeAdd{
		private String city;
		private String state;
		private long pincode;
		public collegeAdd() {
			super();
		}
		public collegeAdd(String city, String state, long pincode) {
			super();
			this.city = city;
			this.state = state;
			this.pincode = pincode;
		}
		@Override
		public String toString() {
			return "collegeAdd [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
		}
		
	}
	public static void main(String[] args) {
		collegeAdd add=new Student.collegeAdd("Hyderabad","telengana",100435);
		Student s1=new Student("ashu",123);
		setAddress(add);
		System.out.println(s1);
	}
	
	}
	
	


