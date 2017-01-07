package com.mpc.main;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.mpc.bean.Employee;
import com.mpc.bean.SpecialDays;
import com.mpc.util.EmployeeImplementation;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EmployeeImplementation em = new EmployeeImplementation();
		
		List<Employee> list = em.populateDataFromDb();
	
		System.out.println("all employees :\n\n");
		
		for(Employee e:list)
		{
			System.out.println(e);
		}
		
		System.out.println("\n\ntotal employees : "+list.size());
		
		
		StringBuffer msg = em.readfromFile("Greeting.txt");
		System.out.println("\n\nmsg frm file : \n"+msg);
		
		int age = em.findAge(Date.valueOf("1993-12-13"));
		
		System.out.println("\n\nur age is : "+age);
		
		
		Map<SpecialDays, List<Employee>> map = em.checkWeekDays(list);
		
		System.out.println("\n\nall employees having bday n anniversary today...\n\n");
		
		for(Map.Entry<SpecialDays, List<Employee>> entry:map.entrySet())
		{
			System.out.println("\nEmployees having: "+ entry.getKey());
			System.out.println("List of emp");
			
			for(Employee temp:entry.getValue())
			{
				System.out.println(temp);
			}
			
			System.out.println("no of employees : "+ entry.getValue().size());
			
		}
		
		
		
		Map<SpecialDays, List<StringBuffer>> msgmap = em.greetingmsg(map, msg);
		
		for(Map.Entry<SpecialDays, List<StringBuffer>> entry: msgmap.entrySet())
		{
			System.out.println("day : "+ entry.getKey());
			System.out.println("\ngreeting msgs\n");
			
			for(StringBuffer sb: entry.getValue())
			{
				System.out.println(sb);
			}
			
			System.out.println("no of msgs : "+ entry.getValue().size());
		}
		
	}

}
