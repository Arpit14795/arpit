package com.mpc.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mpc.bean.Employee;
import com.mpc.bean.SpecialDays;


public class EmployeeImplementation implements EmpImp
{

	@Override
	public List<Employee> populateDataFromDb() {
		 
		List<Employee> list= new ArrayList<Employee>();
		
		ConnectionManager cn = new ConnectionManager();
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="select * from emp_tbl";
		
		try {
			
			con = cn.getConnection();
			
			st = con.createStatement();
			
			rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				int eid = rs.getInt(1);
				String ename = rs.getString(2);
				Date bdate = rs.getDate(3);
				Date adate = rs.getDate(4);
				
				list.add(new Employee(eid, ename, bdate, adate));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	@Override
	public int findAge(Date birthdate) 
	{
	
		int age=0;
		
		Calendar today = Calendar.getInstance();
		Calendar bdate = Calendar.getInstance();
		
		bdate.setTimeInMillis(birthdate.getTime());
		
		if(bdate.after(today))
		{
			age=0;
			return age;
		}
		
		age = today.get(Calendar.YEAR) - bdate.get(Calendar.YEAR);
		
		if(today.get(Calendar.MONTH)< bdate.get(Calendar.MONTH))
		{
			age--;
		}
		
		else if(today.get(Calendar.MONTH)== bdate.get(Calendar.MONTH))
		{
			if(today.get(Calendar.DATE)<bdate.get(Calendar.DATE))
			{
				age--;
			}
		}
		
		return age;
	}

	@Override
	public Map<SpecialDays, List<Employee>> checkWeekDays(List<Employee> list) 
	{
		 
		Map<SpecialDays, List<Employee>> map = new HashMap<SpecialDays, List<Employee>>();
		
		SpecialDays[] spdays = SpecialDays.values();
		
		for(SpecialDays sp:spdays)
		{
			map.put(sp, new ArrayList<Employee>());
		}
		
	
		Calendar today =Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		Calendar aniday = Calendar.getInstance();
		
		boolean weekday =true;
		
		for(Employee e: list)
		{
			Date bday = e.getEmpBirthDate();
			Date aday = e.getEmpAnniversaryDate();
			
			
			birthday.setTimeInMillis(bday.getTime());
			
			if(aday!=null)
				aniday.setTimeInMillis(aday.getTime());
			
			else
				aniday.set(2016, 1, 1);    			//if nt married...den set anniversary date as future date...so dat der vil nt b any null pointer exception
			
			//check for bday first
			if((birthday.get(Calendar.MONTH)== today.get(Calendar.MONTH))  && (birthday.get(Calendar.DATE) == today.get(Calendar.DATE)) )
			{
				
				//if today is bday...den today shud nt b sat or sun
				
				weekday = checkWeekday(today);
					
				if(weekday)
				{
					
					addtomap(map,e,SpecialDays.BirthDate);
					
				}
			}
			
			//check for anniversary
			if((aniday.get(Calendar.MONTH)== today.get(Calendar.MONTH))  && (aniday.get(Calendar.DATE) == today.get(Calendar.DATE)) )
			{
				
				//if today is anniday...den today shud nt b sat or sun
				
				weekday = checkWeekday(today);
					
				if(weekday)
				{
					
					addtomap(map,e,SpecialDays.AnniversaryDate);
					
				}
			}
			
		}
		
		
		return map;
	}

	//add to map
	
	public void addtomap(Map<SpecialDays, List<Employee>> map, Employee e,
			SpecialDays spday) {

		for(Map.Entry<SpecialDays, List<Employee>> entry : map.entrySet())
		{
			if(entry.getKey().equals(spday))
			{
				entry.getValue().add(e);
			}
		}
		
	}

	//chk whether today is weekday or nt
	public boolean checkWeekday(Calendar today) 
	{
	
		
		
		if(today.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
		{
			return false;
		}
		
		if(today.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
		{
			return false;
		}
		
		
		return true;
	}

	@Override
	public StringBuffer readfromFile(String file) {
		 
		String msg="";
		String line="";
		
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr = new FileReader(file);
			
			br = new BufferedReader(fr);
			
			line = br.readLine();
			
			while(line!=null)
			{
				
				msg= msg.concat(line);
				msg = msg.concat("\n");
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		StringBuffer sb = new StringBuffer(msg);
		
		return sb;
	}

	@Override
	public Map<SpecialDays, List<StringBuffer>> greetingmsg(Map<SpecialDays, List<Employee>> map, StringBuffer s) 
	{
		
		Map<SpecialDays, List<StringBuffer>> msgMap = new HashMap<SpecialDays, List<StringBuffer>>();
		
		SpecialDays[] spdays = SpecialDays.values();
		
		for(SpecialDays spday:spdays)
		{
			msgMap.put(spday, new ArrayList<StringBuffer>());
		}
		
		
		
		for(Map.Entry<SpecialDays, List<Employee>> entry: map.entrySet())
		{
			//for bdays first
			if(entry.getKey().equals(SpecialDays.BirthDate))
			{
		
				for(Employee e: entry.getValue())
				{

					String strmsg = new String(s);
					
					StringBuffer tempmsg = new StringBuffer(strmsg);
					
//					System.out.println("original msg : "+tempmsg);
					String old_string="<NAME>";
					int index = tempmsg.indexOf(old_string);
					
					tempmsg.replace(index, index+old_string.length(), e.getEmpName());
					
					
					old_string="<SPECiALDAY>";
					index = tempmsg.indexOf(old_string);

					/*System.out.println("start : "+index);
					System.out.println("end : "+old_string.length());*/
					tempmsg.replace(index, index+old_string.length(), "Birthday");
					
					old_string="<DATE>";
					index = tempmsg.indexOf(old_string);

					DateFormat df = new SimpleDateFormat("EEEE d,MMMM");
					String strdate = df.format(e.getEmpBirthDate());
					
					tempmsg.replace(index, index+old_string.length(), strdate);
					

					//add to final map
					for(Map.Entry<SpecialDays, List<StringBuffer>> entry2: msgMap.entrySet())
					{
						if(entry.getKey().equals(entry2.getKey()))
						{
							entry2.getValue().add(tempmsg);
//							tempmsg= s;
							System.out.println("bday entry added to map");
						}
					}
					
					
					
					
				}
			}
			
			
			//for anidays 
			if(entry.getKey().equals(SpecialDays.AnniversaryDate))
			{
				
				for(Employee e: entry.getValue())
				{
					String strmsg = new String(s); 
					StringBuffer tempmsg = new StringBuffer(strmsg);
					
//					System.out.println("original msg : "+tempmsg);
							
					String old_string="<NAME>";
					int index = tempmsg.indexOf(old_string);
					

					tempmsg.replace(index, index+old_string.length(), e.getEmpName());
					
					
					old_string="<SPECiALDAY>";
					index = tempmsg.indexOf(old_string);

					tempmsg.replace(index, index+old_string.length(), "Anniversary");
					
					old_string="<DATE>";
					index = tempmsg.indexOf(old_string);

					DateFormat df = new SimpleDateFormat("EEEE d,MMMM");
					String strdate = df.format(e.getEmpAnniversaryDate());
					
					tempmsg.replace(index, index+old_string.length(), strdate);
					

					//add to final map
					for(Map.Entry<SpecialDays, List<StringBuffer>> entry2: msgMap.entrySet())
					{
						if(entry.getKey().equals(entry2.getKey()))
						{
							entry2.getValue().add(tempmsg);
							System.out.println("ani entry added to map");
						}
					}
								
				}
			}

		}
		
		
		return msgMap;
	}
	
}
