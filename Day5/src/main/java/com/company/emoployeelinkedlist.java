package com.company;

public class emoployeelinkedlist {
	String ename;
	int eid;
	double salery;
	String dept;
	String branch;
	public emoployeelinkedlist() {
		super();
	}
	public emoployeelinkedlist(String ename, int eid, double salery, String dept, String branch) {
		super();
		this.ename = ename;
		this.eid = eid;
		this.salery = salery;
		this.dept = dept;
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "emoployeelinkedlist [ename=" + ename + ", eid=" + eid + ", salery=" + salery + ", dept=" + dept
				+ ", branch=" + branch + "]";
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public double getSalery() {
		return salery;
	}
	public void setSalery(double salery) {
		this.salery = salery;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	

}
