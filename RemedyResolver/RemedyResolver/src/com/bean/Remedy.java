package com.bean;

import java.util.Date;

public class Remedy {

	private int id;
	private RemedyCategory category;
	private String desription;
	private Priority priority;
	private Date raisedTime;
//	private RemedyStatus status;
	private Date expectedResolvedTime;
	private Date actualResolvedTime;
	
	private RemedyStatus remedyStatus;

	public Remedy() {

	}

	public Remedy(int remedyId, String desc, Priority priority,
			RemedyCategory remedy_type, RemedyStatus status, Date raised_time,
			Date actual_resolution_time, Date expectedResolvedTime) {
		this.id=remedyId;
		this.desription=desc;
		this.priority=priority;
		this.category=remedy_type;
		this.remedyStatus=status;
		this.raisedTime=raised_time;
		this.actualResolvedTime=actual_resolution_time;
		this.expectedResolvedTime=expectedResolvedTime;
		
	}
	public String toString(){
		return id+" "+desription+" "+priority+" "+category+" "+remedyStatus+
				" "+raisedTime+" "+actualResolvedTime+" "+expectedResolvedTime+"\n";
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RemedyCategory getCategory() {
		return category;
	}

	public void setCategory(RemedyCategory category) {
		this.category = category;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Date getRaisedTime() {
		return raisedTime;
	}

	public void setRaisedTime(Date raisedTime) {
		this.raisedTime = raisedTime;
	}

	public RemedyStatus getStatus() {
		return remedyStatus;
	}

	public void setStatus(RemedyStatus status) {
		this.remedyStatus = status;
	}

	public Date getExpectedResolvedTime() {
		return expectedResolvedTime;
	}

	public void setExpectedResolvedTime(Date expectedResolvedTime) {
		this.expectedResolvedTime = expectedResolvedTime;
	}

	public Date getActualResolvedTime() {
		return actualResolvedTime;
	}

	public void setActualResolvedTime(Date actualResolvedTime) {
		this.actualResolvedTime = actualResolvedTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((actualResolvedTime == null) ? 0 : actualResolvedTime
						.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((desription == null) ? 0 : desription.hashCode());
		result = prime
				* result
				+ ((expectedResolvedTime == null) ? 0 : expectedResolvedTime
						.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((priority == null) ? 0 : priority.hashCode());
		result = prime * result
				+ ((raisedTime == null) ? 0 : raisedTime.hashCode());
		result = prime * result
				+ ((remedyStatus == null) ? 0 : remedyStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Remedy other = (Remedy) obj;
		if (actualResolvedTime == null) {
			if (other.actualResolvedTime != null)
				return false;
		} else if (!actualResolvedTime.equals(other.actualResolvedTime))
			return false;
		if (category != other.category)
			return false;
		if (desription == null) {
			if (other.desription != null)
				return false;
		} else if (!desription.equals(other.desription))
			return false;
		if (expectedResolvedTime == null) {
			if (other.expectedResolvedTime != null)
				return false;
		} else if (!expectedResolvedTime.equals(other.expectedResolvedTime))
			return false;
		if (id != other.id)
			return false;
		if (priority != other.priority)
			return false;
		if (raisedTime == null) {
			if (other.raisedTime != null)
				return false;
		} else if (!raisedTime.equals(other.raisedTime))
			return false;
		if (remedyStatus != other.remedyStatus)
			return false;
		return true;
	}
	
	
}
