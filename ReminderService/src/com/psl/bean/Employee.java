package com.psl.bean;

import java.util.Date;

public class Employee {
	private int employeeid;
	private String employeeName;
	private Date birthDate;
	private Date anniversaryDate;
	private int age;
	private int annyAge;
	
	
	
	
	public int getAnnyAge() {
		return annyAge;
	}
	public void setAnnyAge(int annyAge) {
		this.annyAge = annyAge;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getAnniversaryDate() {
		return anniversaryDate;
	}
	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}
	public Employee(int employeeid, String employeeName, Date birthDate,
			Date anniversaryDate) {
		super();
		this.employeeid = employeeid;
		this.employeeName = employeeName;
		this.birthDate = birthDate;
		this.anniversaryDate = anniversaryDate;
	}
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeeName="
				+ employeeName + ", birthDate=" + birthDate
				+ ", anniversaryDate=" + anniversaryDate + "]";
	}
	

}
