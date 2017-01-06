package com.psl.beans;

import java.util.List;

public class Student implements  Comparable<Student> {
	private int rollno;
	private String studentName;
	private int age;
	private List<Address> address;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Address> getList() {
		return address;
	}
	public void setList(List<Address> address) {
		this.address = address;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
