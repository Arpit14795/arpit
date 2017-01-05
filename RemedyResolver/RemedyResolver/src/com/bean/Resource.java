package com.bean;

import java.util.List;

public class Resource {

	private int resourceId;
	private String resourceName;
	private String department;
	private List<Remedy> listOfRemedies;

	public Resource() {

	}

	public Resource(int resourceId, String name, String depart) {
		this.resourceId=resourceId;
		this.resourceName=name;
		this.department=depart;
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return resourceId+" "+resourceName+" "+department+" "+listOfRemedies+"\n";
	}
	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Remedy> getListOfRemedies() {
		return listOfRemedies;
	}

	public void setListOfRemedies(List<Remedy> listOfRemedies) {
		this.listOfRemedies = listOfRemedies;
	}

}
