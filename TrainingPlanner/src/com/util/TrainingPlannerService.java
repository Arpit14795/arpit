package com.util;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.beans.Batch;
import com.beans.BatchTemplate;
import com.beans.BatchType;
import com.beans.Location;
import com.beans.Trainer;
import com.exceptions.InvalidLocationException;

public interface TrainingPlannerService {

	String MESSAGE = " Find the list of evaluated trainers for the following Skill/s ";

	List<Location> populateTrainingLocations();

	List<Trainer> populateTrainerDetails();

	List<BatchTemplate> populateBatchTemplate(File file);

	Map<String, Integer> searchLocationsWiseClassroomsAlongWithCapacity(String locationName, List<Location> locations) throws InvalidLocationException;

	List<Batch> createBatches(Map<BatchType, Map<String, Integer>> trainingRequirement,List<Location> location);

	Batch generateBatchSchedule(Batch batch, List<BatchTemplate> batchTemplate,
			Date batchStartDate);

	Batch assignTrainersToBatch(Batch batch, List<Trainer> trainers);

	List<String> findUnassignedCourses(Batch batch);

	String raiseTrainerRequirement(List<String> courses);

}
