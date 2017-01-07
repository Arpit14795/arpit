package com.psl.client;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.psl.bean.Employee;
import com.psl.bean.EventEnum;
import com.psl.exception.InvalidDayException;
import com.psl.util.ReminderServiceImpl;

public class Client {
	public static void main(String[] args) {
		ReminderServiceImpl obj=new ReminderServiceImpl();
		List<Employee> list=obj.fetchAllEmployeeDetails();
		for(Employee e:list){
			System.out.println(e);
			try {
				int age=obj.calculateEventYears(e.getBirthDate(), new java.sql.Date(new Date().getTime()));
				e.setAge(age);
				if(e.getAnniversaryDate()!=null){
					int any=obj.calculateEventYears(e.getAnniversaryDate(), new java.sql.Date(new Date().getTime()));
					e.setAnnyAge(any);
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		StringBuffer sb=obj.fetchEventMessage("EventMessageFileTxt.txt");
		System.out.println(sb.toString());
		Map<EventEnum, Set<Employee>> map=null;
		try {
			map=obj.fetchEventDetails(list, new java.sql.Date(new Date().getTime()));
			for(Map.Entry<EventEnum, Set<Employee>> m:map.entrySet()){
				System.out.println(m.getKey());
				for(Employee e:m.getValue())
					System.out.println(e);
			}
		} catch (InvalidDayException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map<EventEnum, List<StringBuffer>> map1=obj.employeeWishContent(map, sb);
		for(Map.Entry<EventEnum, List<StringBuffer>> m:map1.entrySet()){
			System.out.println(m.getKey());
			for(StringBuffer s:m.getValue())
				System.out.println(s.toString());
			System.out.println();
		}
		
	}

}
