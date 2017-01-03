package com.beans;

import java.util.Map;

public class Trainer {
	private int trainerId;
	private String trainerName;

	private Map<String, Integer> skillPrefenceMap;

	public Trainer() {
		// TODO Auto-generated constructor stub
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Map<String, Integer> getSkillPrefenceMap() {
		return skillPrefenceMap;
	}

	public void setSkillPrefenceMap(Map<String, Integer> skillPrefenceMap) {
		this.skillPrefenceMap = skillPrefenceMap;
	}

	

}
