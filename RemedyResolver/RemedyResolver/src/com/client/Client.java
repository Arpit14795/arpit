
package com.client;

import java.util.List;
import java.util.Map;

import com.bean.Remedy;
import com.bean.RemedyCategory;
import com.bean.RemedyStatus;
import com.bean.Resource;
import com.exceptions.InsufficientBandWidthException;
import com.util.RemedyResolverImpl;

public class Client {
	public static void main(String[] args) {
		
		RemedyResolverImpl obj=new RemedyResolverImpl();
		List<Remedy> remedyList=obj.populateRemedyDetails();
//		for(Remedy r:remedyList)
//			System.out.println(r);
//		System.out.println();
		List<Resource> resourse=obj.populateResourceDetails("resourceDetails.txt", remedyList);
		for(Resource r:resourse)
			System.out.println(r);
		System.out.println();
		RemedyStatus[] rs=new RemedyStatus[3];
		rs[0]=RemedyStatus.INPROGRESS;
		rs[1]=RemedyStatus.PENDING;
		rs[2]=RemedyStatus.RESOLVED;
		List<Remedy> remedyByStatus=obj.getRemediesByStatus(remedyList, rs);
//		for(Remedy r:remedyByStatus)
//			System.out.println(r);
		
		Remedy rem=remedyList.get(4);
		try {
			
			obj.allocateRemedy(rem, resourse, remedyList);
		} catch (InsufficientBandWidthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Resource r:resourse)
			System.out.println(r);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*RemedyResolverImpl obj=new RemedyResolverImpl();
		List<Remedy> remedyList=obj.populateRemedyDetails();
		for(Remedy r:remedyList)
			System.out.println(r);
		System.out.println();
		List<Resource> resourse=obj.populateResourceDetails("resourceDetails.txt", remedyList);
		for(Resource r:resourse)
			System.out.println(r);
		System.out.println();
		RemedyStatus[] rs=new RemedyStatus[3];
		rs[0]=RemedyStatus.ASSIGNED;
		rs[1]=RemedyStatus.NEW;
		rs[2]=RemedyStatus.DELAYED;
		List<Remedy> remedyByStatus=obj.getRemediesByStatus(remedyList, rs);
		for(Remedy r:remedyByStatus)
			System.out.println(r);
		System.out.println();
		Remedy rem=remedyList.get(14);
		try {
			
			obj.allocateRemedy(rem, resourse, remedyList);
		} catch (InsufficientBandWidthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Resource r:resourse)
			System.out.println(r);
		System.out.println();
		obj.closeRemedy(rem, resourse, remedyList);
		for(Resource r:resourse)
			System.out.println(r);
		System.out.println();
		Map<RemedyCategory, Map<RemedyStatus, Integer>> map=obj.GenerateReportOfDelayedOrUnAttendedRemedies(remedyList);
		for(Map.Entry<RemedyCategory, Map<RemedyStatus, Integer>> m:map.entrySet()){
			System.out.println(m.getKey().toString());
			for(Map.Entry<RemedyStatus, Integer> n:m.getValue().entrySet()){
				System.out.println(n.getKey()+"\t "+n.getValue());
			}
		}
		
		*/
	}
}
		










































































