package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.bean.Priority;
import com.bean.Remedy;
import com.bean.RemedyCategory;
import com.bean.RemedyStatus;
import com.bean.Resource;
import com.exceptions.InsufficientBandWidthException;

public class Solve {


	public List<Remedy> populateRemedyDetails() {
		// TODO Auto-generated method stub
		List<Remedy> list=new ArrayList<Remedy>();
		ConnectionManager db=new ConnectionManager();
		Connection conn=null;
		Statement st=null;
		try{
			conn=db.getConnection();
			st=conn.createStatement();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			ResultSet rs=st.executeQuery("select * from remedy_tbl");
			while(rs.next()){
				int id=rs.getInt(1);
				String desc=rs.getString(2);
				Priority priority=Priority.valueOf(rs.getString(3).toUpperCase());
				RemedyCategory rc=RemedyCategory.valueOf(rs.getString(4).toUpperCase());
				RemedyStatus rrs=RemedyStatus.valueOf(rs.getString(5).toUpperCase());
				Date raisedTime=rs.getTimestamp(6);
				Date actualTime=rs.getDate(7);
				Calendar cal=Calendar.getInstance();
				cal.setTime(raisedTime);
				cal.add(Calendar.HOUR, rc.getExpectedResponseTime());
				Date exceptedTime=cal.getTime();
				list.add(new Remedy(id, desc, priority, rc, rrs, raisedTime, actualTime, exceptedTime));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	
	public List<Resource> populateResourceDetails(String filename,
			List<Remedy> list) {
		// TODO Auto-generated method stub
		List<Resource> resource=new ArrayList<Resource>();
		BufferedReader br=null;
		try{
			br=new BufferedReader(new FileReader(new File(filename)));
			String line=null,token[];
			while((line=br.readLine())!=null){
				if(line.equals(""))
					continue;
				else{
					token=line.split(",");
					String[] s;
					Resource re=new Resource(Integer.parseInt(token[0].trim()), token[1].trim(), token[2].trim());
					re.setListOfRemedies(new ArrayList<Remedy>());
					resource.add(re);
					if(token.length==4){
						s=token[3].split(":");
					
						for(String ss:s){
							for(Remedy r:list){
								if(ss.equals(r.getId()+"")){
									re.getListOfRemedies().add(r);
								}
							}
						}
					}
				}
			}
			br.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return resource;
	}


	public List<Remedy> getRemediesByStatus(List<Remedy> remedies,
			RemedyStatus... status) {
		// TODO Auto-generated method stub
		List<Remedy> remedyByStatus=new ArrayList<Remedy>();
		RemedyStatus[] rs=status;
		for(RemedyStatus r:rs){
			for(Remedy re:remedies){
				if(r.equals(re.getStatus()))
					remedyByStatus.add(re);
			}
		}
		return remedyByStatus;
	}


	public void allocateRemedy(Remedy remedy, List<Resource> resourceList,
			List<Remedy> remedyList) throws InsufficientBandWidthException {
		// TODO Auto-generated method stub
		boolean flag=false; 
		outer:
		for(Resource r:resourceList){
			if(r.getListOfRemedies().size()<3){
				for(Remedy re:remedyList){
					if(remedy.getCategory().equals(re.getCategory()) && remedy.getCategory().toString().equals(r.getDepartment()) && remedy.getId()==re.getId())
					{
						remedy.setStatus(RemedyStatus.ASSIGNED);
						r.getListOfRemedies().add(remedy);
						flag=true;
						break outer;
					}
				}
			}
			else if(r.getListOfRemedies().size()==3){
				for(int i=0;i<r.getListOfRemedies().size();i++){
					if(remedy.getPriority().compareTo(r.getListOfRemedies().get(i).getPriority())>0){
						r.getListOfRemedies().remove(i);
						r.getListOfRemedies().set(i, remedy);
						remedy.setStatus(RemedyStatus.ASSIGNED);
						flag=true;
						break outer;
					}
				}
			}
		}
		if(!flag)
			throw new InsufficientBandWidthException();
	}


	public void closeRemedy(Remedy rem, List<Resource> resourceList,
			List<Remedy> remedyList) {
		// TODO Auto-generated method stub
		for(Resource re:resourceList){
			Iterator<Remedy> itr=re.getListOfRemedies().iterator();
			while(itr.hasNext()){
				Remedy r=itr.next();
				if(rem.getId()==r.getId()){
					rem.setStatus(RemedyStatus.RESOLVED);
					itr.remove();
				}				
			}
		}
		
	}


	public Map<RemedyCategory, Map<RemedyStatus, Integer>> GenerateReportOfDelayedOrUnAttendedRemedies(
			List<Remedy> remedyList) {
		// TODO Auto-generated method stub
		Map<RemedyCategory,Map<RemedyStatus, Integer>> map=new TreeMap<RemedyCategory, Map<RemedyStatus,Integer>>(new Comparator<RemedyCategory>() {
			@Override
			public int compare(RemedyCategory o1, RemedyCategory o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		Map<RemedyStatus, Integer> map1=new TreeMap<RemedyStatus, Integer>(new Comparator<RemedyStatus>() {
			@Override
			public int compare(RemedyStatus o1, RemedyStatus o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		for(Remedy r:remedyList){
			if(r.getActualResolvedTime()!=null){
			if(r.getActualResolvedTime().after(r.getExpectedResolvedTime()))
					r.setStatus(RemedyStatus.DELAYED);
			if(!r.getStatus().equals(RemedyStatus.RESOLVED) && r.getActualResolvedTime().before(new Date()))
					r.setStatus(RemedyStatus.UN_ATTENDED);
			}
		}
		for(Remedy r:remedyList){
			if(r.getStatus().equals(RemedyStatus.RESOLVED)||r.getStatus().equals(RemedyStatus.UN_ATTENDED))
			{
				map1.put(r.getStatus(), r.getId());
				map.put(r.getCategory(), map1);
			}
		}
		return map;
	}
	

}
