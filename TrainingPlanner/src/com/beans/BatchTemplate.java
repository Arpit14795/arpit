package com.beans;

import java.util.HashMap;
import java.util.Map;

public class BatchTemplate {
	private BatchType batchType;
	private Map<String, Integer> coursesWithDuration=new HashMap<String, Integer>();

	public BatchTemplate() {
		// TODO Auto-generated constructor stub
	}

	public BatchType getBatchType() {
		return batchType;
	}

	public void setBatchType(BatchType batchType) {
		this.batchType = batchType;
	}

	public Map<String, Integer> getCoursesWithDuration() {
		return coursesWithDuration;
	}

	public void setCoursesWithDuration(Map<String, Integer> coursesWithDuration) {
		this.coursesWithDuration = coursesWithDuration;
	}

	


}
