package com.util;

import java.io.File;
import java.util.List;
import java.util.Map;


import com.bean.Remedy;
import com.bean.RemedyCategory;
import com.bean.RemedyStatus;
import com.bean.Resource;
import com.exceptions.InsufficientBandWidthException;


public interface RemedyResolver {
	
	// populate Remedy Data from database
	 List<Remedy> populateRemedyDetails();
	 
	 // populate resource details from resourceDetails.txt file provided at the level of /src
	 List<Resource> populateResourceDetails(String filename, List<Remedy> list);
	
	 
	 // Search remedies from the existing list as per the specified status
	 List<Remedy> getRemediesByStatus(List<Remedy> remedies,RemedyStatus... status );
	 
	
	 //allocate new/pending specified remedy to the available free resource 
	 //status of all allocated remedies can be Assigned - in-progress
	 // If the priority of new Remedy is Higher than the assigned remedies then replace the low priority recent remedy
	 // The replaced remedy should have pending status.
	  void  allocateRemedy(Remedy remedy, List<Resource> resourceList,List<Remedy> remedyList) throws InsufficientBandWidthException;
	 
	 //resource closes the remedy 
	 //Close remedies are represented with resolved status also the actual resolve time is updated for them.
	 void closeRemedy(Remedy rem,List<Resource> resourceList, List<Remedy> remedyList);
	

	 
	 // Find out the delayed or unattended remedies as per the remedyCategory
	 public Map<RemedyCategory,Map<RemedyStatus, Integer>> GenerateReportOfDelayedOrUnAttendedRemedies(List<Remedy> remedyList);


	 

}
