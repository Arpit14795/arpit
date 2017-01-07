package com.psl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.psl.bean.Employee;
import com.psl.bean.EventEnum;
import com.psl.exception.InvalidDayException;

public class ReminderServiceImpl implements ReminderServices {

	@Override
	public int calculateEventYears(Date eventDate, Date sysDate)
			throws Exception {
		// TODO Auto-generated method stub
		int age=0;
		Calendar now=Calendar.getInstance();
		now.setTime(sysDate);
		int nowDate=now.get(Calendar.DATE);
		int nowMonth=now.get(Calendar.MONTH)+1;
		int nowYear=now.get(Calendar.YEAR);
		
		Calendar eCal=Calendar.getInstance();
		eCal.setTime(eventDate);
		int eDate=eCal.get(Calendar.DATE);
		int eMonth=eCal.get(Calendar.MONTH)+1;
		int eYear=eCal.get(Calendar.YEAR);
		
		age=nowYear-eYear;
		int rMonth=nowMonth-eMonth;
		int rDate=nowDate-eDate;
		if(rMonth<0){
			rMonth=rMonth+12;
			age--;
			if(rDate<0){
				rMonth--;
				rDate=rDate+30;
				if(rMonth<0){
					age--;
					rMonth=rMonth+12;
				}
			}
		}
		if(rDate<0){
			rMonth--;
			rDate=rDate+30;
			if(rMonth<0){
				age--;
				rMonth=rMonth+12;
			}
		}
		System.out.println(sysDate+"\t"+eventDate+"\t"+age+"\tyrs "+rMonth+"\tmonths "+rDate+" days");
		return age;
	}

	@Override
	public Map<EventEnum, List<StringBuffer>> employeeWishContent(
			Map<EventEnum, Set<Employee>> empListMap, StringBuffer msg) {
		// TODO Auto-generated method stub
		Map<EventEnum, List<StringBuffer>> map=new HashMap<EventEnum, List<StringBuffer>>();
		StringBuffer sb=null;
		List<StringBuffer> birthDaySB=new ArrayList<StringBuffer>();
		List<StringBuffer> anniSB=new ArrayList<StringBuffer>();
		for(Map.Entry<EventEnum, Set<Employee>> m:empListMap.entrySet()){
			map.put(m.getKey(), new ArrayList<StringBuffer>());
			for(Employee e:m.getValue()){
				String s=msg.toString();
				s=s.replace("<NAME>", e.getEmployeeName());
				s=s.replace("<EVENT>",m.getKey().toString());
				if(m.getKey().equals(EventEnum.BIRTHDAY)){
					s=s.replace("<EVENTDATE>", e.getBirthDate().toString());
					s=s.replace("<AGE>", ""+e.getAge());
					sb=new StringBuffer(s);
					birthDaySB.add(sb);
					
				}
				if(m.getKey().equals(EventEnum.ANNIVERSARY)){
					s=s.replace("<EVENTDATE>", e.getAnniversaryDate().toString());
					s=s.replace("<AGE>", ""+e.getAnnyAge());
					sb=new StringBuffer(s);
					anniSB.add(sb);
					
				}
			}
			if(m.getKey().equals(EventEnum.ANNIVERSARY))
				map.get(m.getKey()).addAll(anniSB);
			if(m.getKey().equals(EventEnum.BIRTHDAY))
				map.get(m.getKey()).addAll(birthDaySB);
			
		}
		return map;
	}

	@Override
	public List<Employee> fetchAllEmployeeDetails() {
		// TODO Auto-generated method stub
		List<Employee> list=new ArrayList<Employee>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/augustdb", "root", "root");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from emp_tbl");
			while(rs.next()){
				list.add(new Employee(rs.getInt(1), rs.getString(2) , rs.getDate(3), rs.getDate(4)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public Map<EventEnum, Set<Employee>> fetchEventDetails(
			List<Employee> empList, Date date) throws InvalidDayException {
		// TODO Auto-generated method stub
		Map<EventEnum, Set<Employee>> map=new HashMap<EventEnum, Set<Employee>>();
		Set<Employee> birthDaySet=new HashSet<Employee>();
		Set<Employee> anniversarySet=new HashSet<Employee>();
		map.put(EventEnum.BIRTHDAY, birthDaySet);
		map.put(EventEnum.ANNIVERSARY, anniversarySet);
		Calendar now=Calendar.getInstance();
		now.setTime(date);
		for(Employee e:empList){
			Calendar bCal=Calendar.getInstance();
			bCal.setTime(e.getBirthDate());
			if(bCal.get(Calendar.DAY_OF_WEEK)>1 && bCal.get(Calendar.DAY_OF_WEEK)<7)
				birthDaySet.add(e);
			if(e.getAnniversaryDate()==null)
				continue;
			Calendar nCal=Calendar.getInstance();
			nCal.setTime(e.getAnniversaryDate());
			if(nCal.get(Calendar.DAY_OF_WEEK)>1 && nCal.get(Calendar.DAY_OF_WEEK)<7)
				anniversarySet.add(e);
		}
		return map;
	}

	@Override
	public StringBuffer fetchEventMessage(String fileName) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		BufferedReader br=null;
		try{
			br=new BufferedReader(new FileReader(new File(fileName)));
			String line=null;
			while((line=br.readLine())!=null)
				sb.append(line).append("\n");
			br.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return sb;
	}

	@Override
	public void sortEmployeesByName(Set<Employee> empSet) {
		// TODO Auto-generated method stub
		Set<Employee> set=new TreeSet<Employee>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getEmployeeName().compareTo(o2.getEmployeeName());
			}
		});
	}

}
