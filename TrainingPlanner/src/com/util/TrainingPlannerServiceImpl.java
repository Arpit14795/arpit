package com.util;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.beans.Batch;
import com.beans.BatchTemplate;
import com.beans.BatchType;
import com.beans.Location;
import com.beans.Trainer;
import com.exceptions.InvalidLocationException;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class TrainingPlannerServiceImpl implements TrainingPlannerService {

	public final Map<BatchType, Map<String, Integer>> getTrainingRequirement() {
		Map<BatchType, Map<String, Integer>> trainingRequirement = new HashMap<>();
		Map<String, Integer> locationWiseCount = new HashMap<>();
		// location wise count of candidates for Standard Java batch
		locationWiseCount.put("Hinjawadi", 80);
		locationWiseCount.put("Goa", 15);
		locationWiseCount.put("Bangalore", 10);
		locationWiseCount.put("Nagpur", 10);
		trainingRequirement.put(BatchType.STANDARD_JAVA, locationWiseCount);

		locationWiseCount = new HashMap<>();
		// location wise count of candidates for QE batch
		locationWiseCount.put("Hinjawadi", 10);
		locationWiseCount.put("Goa", 5);
		locationWiseCount.put("Bangalore", 4);
		locationWiseCount.put("Nagpur", 8);
		trainingRequirement.put(BatchType.QE, locationWiseCount);

		locationWiseCount = new HashMap<>();
		// location wise count of candidates for full stack batch
		locationWiseCount.put("Hinjawadi", 10);
		locationWiseCount.put("Goa", 8);
		locationWiseCount.put("Nagpur", 9);
		trainingRequirement.put(BatchType.FULL_STACK, locationWiseCount);
		return trainingRequirement;

	}

	@Override
	public List<Location> populateTrainingLocations()
	{
		List<Location> list=new ArrayList<Location>();
		ConnectionManagerImpl cm=new ConnectionManagerImpl();
		Connection c=cm.getConnection();
		try {
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from location_tbl");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Trainer> populateTrainerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BatchTemplate> populateBatchTemplate(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> searchLocationsWiseClassroomsAlongWithCapacity(
			String locationName, List<Location> locations)
			throws InvalidLocationException {
		// TODO Auto-generated method stub
		Map<String, Integer> map= new LinkedHashMap<String, Integer>();
		return null;
	}

	@Override
	public List<Batch> createBatches(
			Map<BatchType, Map<String, Integer>> trainingRequirement,
			List<Location> location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Batch generateBatchSchedule(Batch batch,
			List<BatchTemplate> batchTemplate, Date batchStartDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Batch assignTrainersToBatch(Batch batch, List<Trainer> trainers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findUnassignedCourses(Batch batch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String raiseTrainerRequirement(List<String> courses) {
		// TODO Auto-generated method stub
		return null;
	}

}
