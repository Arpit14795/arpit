package com.psl.bean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Assignment {
	private int rollNumber;
	private String subject;
	private java.util.Date submissionDate;
	private int marksObtained;
	private int numberOfSubmissions;
	
	
	public Assignment(int rol, String subj, Date sub, int i, int j) {
		// TODO Auto-generated constructor stub
		this.rollNumber=rol;
		this.subject=subj;
		this.submissionDate=sub;
		this.marksObtained=i;
		this.numberOfSubmissions=j;
		
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}	
	public java.util.Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(java.util.Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public int getNumberOfSubmissions() {
		return numberOfSubmissions;
	}
	public void setNumberOfSubmissions(int numberOfSubmissions) {
		this.numberOfSubmissions = numberOfSubmissions;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String toString(){
		return rollNumber+" "+new SimpleDateFormat("dd:MM:yyyy").format(submissionDate)+" "+marksObtained+" "+numberOfSubmissions+" "+ subject+"\n";
	}
	
}