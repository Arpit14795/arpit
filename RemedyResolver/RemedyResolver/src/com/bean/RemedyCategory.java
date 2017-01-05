package com.bean;

public enum RemedyCategory {

	ITIG(36),ADMIN(48),FINANCE(72),HR(24);
	private int expectedResponseTime;
	private RemedyCategory(int expectedResponseTime) {
		this.expectedResponseTime=expectedResponseTime;
	}
	public int getExpectedResponseTime() {
		return expectedResponseTime;
	}
	
}
