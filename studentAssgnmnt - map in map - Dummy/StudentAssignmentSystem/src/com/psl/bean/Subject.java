package com.psl.bean;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
public class Subject {
	private String subjectName;
	private java.util.Date assignmentIssueDate;
	private int numberOfSubmissions = 0;
	
	public Subject(String subjectName, java.util.Date assignmentIssueDate) {
		super();
		this.subjectName=subjectName;
		this.assignmentIssueDate=assignmentIssueDate;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public java.util.Date getAssignmentIssueDate() {
		return assignmentIssueDate;
	}
	public void setAssignmentIssueDate(Date assignmentIssueDate) {
		this.assignmentIssueDate = assignmentIssueDate;
	}
	public int getNumberOfSubmissions() {
		return numberOfSubmissions;
	}
	public void setNumberOfSubmissions(int numberOfSubmissions) {
		this.numberOfSubmissions = numberOfSubmissions;
	}
	public String toString()
	{
		return subjectName+" "+new SimpleDateFormat("dd:MM:yyyy").format(assignmentIssueDate)+" "+numberOfSubmissions;
	}
	
	
}