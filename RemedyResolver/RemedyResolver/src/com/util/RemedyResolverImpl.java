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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.bean.Priority;
import com.bean.Remedy;
import com.bean.RemedyCategory;
import com.bean.RemedyStatus;
import com.bean.Resource;
import com.exceptions.InsufficientBandWidthException;

public class RemedyResolverImpl  implements RemedyResolver 
{
	ConnectionManager cm=new ConnectionManager();
	@Override
	public List<Remedy> populateRemedyDetails() 
	{
		List<Remedy> list=new ArrayList<Remedy>();
		Connection con=cm.getConnection();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from remedy_tbl");
			Remedy rd;
			while(rs.next())
			{
				Date raised_time=rs.getTimestamp(6);
				Date actual_resolution_time=rs.getTimestamp(7);
				GregorianCalendar gc =new GregorianCalendar();
				gc.setTime(raised_time);
				gc.add(Calendar.HOUR,
						RemedyCategory.valueOf(rs.getString(4).toUpperCase()).getExpectedResponseTime());
				
				Date expectedResolvedTime=gc.getTime();
				rd=new Remedy(rs.getInt(1), rs.getString(2), Priority.valueOf(rs.getString(3).toUpperCase()),
						RemedyCategory.valueOf(rs.getString(4).toUpperCase()), 
						RemedyStatus.valueOf(rs.getString(5).toUpperCase()),raised_time,
						actual_resolution_time, 
						expectedResolvedTime);
				list.add(rd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return list;
	}
	
	@Override
	public List<Resource> populateResourceDetails(String filename,
			List<Remedy> list) 
			{
		
		List<Resource> resource_list=new ArrayList<Resource>();
		try(Scanner sc=new Scanner(new File(filename)))
		{
			while(sc.hasNextLine())
			{
				Resource resource;
				List<Remedy> remedy_list=new ArrayList<Remedy>();
			String str[]=sc.nextLine().split("[,:]");
			int size=4;
			resource=new Resource(Integer.parseInt(str[0].trim()), str[1].trim(),str[2].trim());
			while(str.length>=size)
			{
				for (Remedy remedy:list) 
				{
					if(remedy.getId()==Integer.parseInt(str[size-1]))
						remedy_list.add(remedy);
				}
				size++;
			}
			resource.setListOfRemedies(remedy_list);
			resource_list.add(resource);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resource_list;
	}

	@Override
	public List<Remedy> getRemediesByStatus(List<Remedy> remedies,
			RemedyStatus... status)
			{
		List<Remedy> list=new ArrayList<Remedy>();
		for (int i = 0; i < status.length; i++) 
		{
			for (Remedy remedy : remedies)
			{
				if(remedy.getStatus().ordinal()==status[i].ordinal())
					list.add(remedy);
			}
			
		}
		return list;
	}

	@Override
	public void allocateRemedy(Remedy remedy, List<Resource> resourceList,
			List<Remedy> remedyList) throws InsufficientBandWidthException 
	{
		for (Remedy r2 : remedyList) 
		{
			if(r2.equals(remedy))
			{
				List<Resource> list=new ArrayList<Resource>();
				for (Resource resource : resourceList)
				{
					if(remedy.getCategory().toString().equals(resource.getDepartment()))
						list.add(resource);
				}
				Collections.sort(list, new Comparator<Resource>()
						{
							@Override
							public int compare(Resource o1, Resource o2) {
								// TODO Auto-generated method stub
								return o1.getListOfRemedies().size()-o2.getListOfRemedies().size();
							}
						});
				boolean flag=false; 
				outer:
				for (Resource resource : list)
				{
					int i=0;
					for (Remedy r : resource.getListOfRemedies())
					{
						if(resource.getListOfRemedies().size()<3)
						{
							remedy.setStatus(RemedyStatus.ASSIGNED);
							resource.getListOfRemedies().add(remedy);
							flag=true;
							break outer;
						}
						if((resource.getListOfRemedies().size()==3) && (r.getPriority().ordinal()>
						remedy.getPriority().ordinal()))
						{
							resource.getListOfRemedies().remove(i);
							resource.getListOfRemedies().set(i, remedy);
							flag=true;
							break outer;
						}
							i++;
					}
				}
				if(!flag)
					throw new InsufficientBandWidthException();
				/*for  (Resource resource : resourceList)
				{
					for(Resource resource2 : list)
					if( resource2.hashCode()==resource.hashCode())
					{
						System.out.println(resource);
						resource.setListOfRemedies(resource2.getListOfRemedies());
						System.out.println(resource);
					}
				}*/
			}
		}
	}

	@Override
	public void closeRemedy(Remedy rem, List<Resource> resourceList,
			List<Remedy> remedyList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<RemedyCategory, Map<RemedyStatus, Integer>> GenerateReportOfDelayedOrUnAttendedRemedies(
			List<Remedy> remedyList) {
		// TODO Auto-generated method stub
		return null;
	}

	
}