package com.beans;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public class Batch {
	private BatchType batchType;
	private Map<String,Integer> classRoomNameWithCandidateCount;
	private int totalCountOfCandidates;
	private Date batchStartDate;
	private List<ScheduleDetail> scheduleDetails;

	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public BatchType getBatchType() {
		return batchType;
	}

	public void setBatchType(BatchType batchType) {
		this.batchType = batchType;
	}

	public Map<String, Integer> getClassRoomNameWithCandidateCount() {
		return classRoomNameWithCandidateCount;
	}

	public void setClassRoomNameWithCandidateCount(
			Map<String, Integer> classRoomNameWithCandidateCount) {
		this.classRoomNameWithCandidateCount = classRoomNameWithCandidateCount;
	}

	public int getTotalCountOfCandidates() {
		return totalCountOfCandidates;
	}

	public void setTotalCountOfCandidates(int totalCountOfCandidates) {
		this.totalCountOfCandidates = totalCountOfCandidates;
	}

	public Date getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public List<ScheduleDetail> getScheduleDetails() {
		return scheduleDetails;
	}

	public void setScheduleDetails(List<ScheduleDetail> scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}

	

	
	
}
