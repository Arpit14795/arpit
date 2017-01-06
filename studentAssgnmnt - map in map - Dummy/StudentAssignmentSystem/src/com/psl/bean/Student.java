package com.psl.bean;
public class Student {
	private int rollNumber;
	private String studentname;
	private String subject;
	private boolean defaulter;
	
	
	
	public Student(int rn, String sname, String subject) {
		// TODO Auto-generated constructor stub
		this.rollNumber=rn;
		this.studentname=sname;
		this.subject=subject;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public boolean getDefaulter() {
		return defaulter;
	}
	public void setDefaulter(boolean defaulter) {
		this.defaulter = defaulter;
	}
	public String toString(){
		return rollNumber+" "+studentname+" "+subject+" "+defaulter;
	}
	
	
}