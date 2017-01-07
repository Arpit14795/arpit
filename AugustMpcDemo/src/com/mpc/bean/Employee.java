package com.mpc.bean;

import java.sql.Date;

public class Employee 
{
     int empId;
     String empName;
     Date empBirthDate;
     Date empAnniversaryDate;
    
     public Employee()
     {
    	 
     }
     
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getEmpBirthDate() {
		return empBirthDate;
	}
	public void setEmpBirthDate(Date empBirthDate) {
		this.empBirthDate = empBirthDate;
	}
	public Date getEmpAnniversaryDate() {
		return empAnniversaryDate;
	}
	public void setEmpAnniversaryDate(Date empAnniversaryDate) {
		this.empAnniversaryDate = empAnniversaryDate;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empBirthDate=" + empBirthDate + ", empAnniversaryDate="
				+ empAnniversaryDate + "]\n";
	}
	
	public Employee(int empId, String empName, Date empBirthDate,
			Date empAnniversaryDate) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empBirthDate = empBirthDate;
		this.empAnniversaryDate = empAnniversaryDate;
	}
	
	
     
}
