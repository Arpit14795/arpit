package com.bean;

public enum Priority {

	HIGH(1), MEDIUM(2), LOW(3);
	int priority;

	private Priority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}
}
