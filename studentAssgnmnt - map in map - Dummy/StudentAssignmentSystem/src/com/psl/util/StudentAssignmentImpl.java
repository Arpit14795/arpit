package com.psl.util;
import java.io.File;
import java.text.SimpleDateFormat;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;
//import java.util.HashSet;
//import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.Map.Entry;
import java.util.Scanner;
//import java.util.Set;




import com.psl.bean.Assignment;
import com.psl.bean.Student;
import com.psl.bean.Subject;
public class StudentAssignmentImpl implements StudentAssignment {

	@Override
	public Map<Subject, Map<Student, Assignment>> populateData(String fileSubject, String fileStudent,
			String fileAssgnment) {
		// TODO Auto-generated method stub
		
		Map<Subject, Map<Student,Assignment>> map=new HashMap<Subject, Map<Student, Assignment>>();
		Scanner sc1=null;
		try {
			sc1 = new Scanner(new File(fileSubject));
			while(sc1.hasNext())
			{
				String temp[]=sc1.nextLine().split(",");
				Date d=null;
				SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yyyy");
				try {
					d=sdf.parse(temp[1].trim());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Subject sub=new Subject(temp[0].trim(), d);
				map.put(sub, new HashMap<Student,Assignment>());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		Map<Student, Assignment> subMap=new HashMap<Student, Assignment>();
		List<Assignment> listAss=new ArrayList<Assignment>();
		
		try {
			Scanner sc2=new Scanner(new File(fileStudent));
			while(sc2.hasNext())
			{
				String temp[]=sc2.nextLine().split(",");
				Student stu=new Student(Integer.parseInt(temp[0].trim()), temp[1].trim(), temp[2].trim());
				subMap.put(stu, null);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Scanner sc3=new Scanner(new File(fileAssgnment));
			while(sc3.hasNext())
			{
				String temp[]=sc3.nextLine().split(",");
				
				Date d=null;
				SimpleDateFormat sdf=new SimpleDateFormat("dd:MM:yyyy");
				try {
					d=sdf.parse(temp[2].trim());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Assignment ass=new Assignment(Integer.parseInt(temp[0].trim()), temp[1].trim(), d, 0, 0);
				listAss.add(ass);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Entry<Student, Assignment> entry:subMap.entrySet())
		{
			for(Assignment a:listAss)
			{
				if(entry.getKey().getRollNumber()==a.getRollNumber() && entry.getKey().getSubject().equals(a.getSubject()))
				{
					entry.setValue(a);
//					System.out.println(entry);
				}
			}
		}
		
		for(Entry<Subject, Map<Student, Assignment>> e1:map.entrySet())
		{
			for(Entry<Student, Assignment> e2:subMap.entrySet())
			{
				if(e1.getKey().getSubjectName().equals(e2.getKey().getSubject()))
				{
					e1.getValue().put(e2.getKey(), e2.getValue());
				}
			}
		}
		
		
//		for(Entry<Subject, Map<Student,Assignment>> e:map.entrySet())
//		{
//			System.out.println(e);
//		}
		return map;
		
		
		
		
		
		
		
		
		
		
		
		/*
		Scanner sc=null;
		//HashSet<Subject> subset=new HashSet<Subject>();
		ArrayList<Assignment> array = new ArrayList<Assignment>();
		HashMap<Student,Assignment> newmap=new HashMap<Student,Assignment>();
		 Map<Subject, Map<Student, Assignment>> newmap2=new HashMap<Subject, Map<Student, Assignment>>();
		DateFormat df=new SimpleDateFormat("dd:MM:yyyy");
		try {sc=new Scanner(new File(fileSubject));
			while(sc.hasNext()){
				String[] temp=sc.nextLine().split(",");
				String subjectName=temp[0].trim();
				java.util.Date assignmentIssueDate=df.parse(temp[1].trim());
				newmap2.put(new Subject(subjectName,assignmentIssueDate),new HashMap<Student,Assignment>());
				
			}
		} catch (FileNotFoundException e){}
		catch(ParseException e){}
		finally{sc.close();}
		try {sc=new Scanner(new File(fileAssgnment));
		while(sc.hasNext()){
			int rollNumber;
			String subject;
			java.util.Date submissionDate;
			String[] temp=sc.nextLine().split(",");
			rollNumber=Integer.parseInt(temp[0].trim());
			subject=temp[1].trim();
			submissionDate=df.parse(temp[2].trim());
			array.add(new Assignment(rollNumber,subject,submissionDate,0,0));

		}
	} catch (FileNotFoundException e){}
	catch(ParseException e){}
	finally{sc.close();}
		try {sc=new Scanner(new File(fileStudent));
		while(sc.hasNext()){
			String[] temp=sc.nextLine().split(",");
			int rn;
			String sname;
			String subject;
			rn=Integer.parseInt(temp[0].trim());
			sname=temp[1].trim();
			subject=temp[2].trim();
			for(Assignment a:array){
				if(subject.equals(a.getSubject()) && rn==a.getRollNumber()){
					newmap.put(new Student(rn,sname,subject),a);
				}
			}
			
		}
	} catch (FileNotFoundException e){}
	finally{sc.close();}
		for(Map.Entry<Subject,Map<Student,Assignment>> m1:newmap2.entrySet() ){
			for(Map.Entry<Student,Assignment> m2:newmap.entrySet() ){
				if(m1.getKey().getSubjectName().equals(m2.getKey().getSubject())){
					m1.getValue().put(m2.getKey(),m2.getValue());
					m1.getKey().setNumberOfSubmissions(m1.getKey().getNumberOfSubmissions()+1);
				}
			}
		}
		return newmap2;
		*/
	}

	@Override
	public void calculateMarks(Map<Subject, Map<Student, Assignment>> map) {
		
		Calendar issue=Calendar.getInstance();
		Calendar sub=Calendar.getInstance();
		for(Entry<Subject, Map<Student, Assignment>> e1:map.entrySet())
		{
			for(Entry<Student, Assignment> e2:e1.getValue().entrySet())
			{
				issue.setTime(e1.getKey().getAssignmentIssueDate());
				sub.setTime(e2.getValue().getSubmissionDate());
				int days=sub.get(Calendar.DATE)-issue.get(Calendar.DATE);
				if(days<=5)
					e2.getValue().setMarksObtained(45);
				else if(days>5 && days<=10)
					e2.getValue().setMarksObtained(35);
				else
					e2.getValue().setMarksObtained(0);
				
			}
		}
		
//		
//		for(Entry<Subject, Map<Student,Assignment>> e:map.entrySet())
//		{
//			System.out.println(e);
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		for(Map.Entry<Subject,Map<Student,Assignment>> m1:map.entrySet()){
			for(Map.Entry<Student,Assignment> m2 : m1.getValue().entrySet()){
				if(m1.getKey().getSubjectName().equals(m2.getKey().getSubject())){
					long day=((m2.getValue().getSubmissionDate().getTime())-(m1.getKey().getAssignmentIssueDate().getTime()))/(1000*24*3600);
					if(day<=5)
						m2.getValue().setMarksObtained(45);
					if(day>5 && day<=10 )
						m2.getValue().setMarksObtained(35);
					if(day>10)
						m2.getValue().setMarksObtained(0);
				}
				}
			}
			*/
		}

	@Override
	public Map<Subject, Map<Student, Assignment>> generateDefaulterListSubjectWise(
			Map<Subject, Map<Student, Assignment>> map) {
		
		calculateMarks(map);
//		for(Entry<Subject, Map<Student, Assignment>> e:map.entrySet())
//		{
//			System.out.println(e);
//		}
		
		Map<Subject,Map<Student,Assignment>> newMap=new HashMap<Subject, Map<Student,Assignment>>();
		Map<Student,Assignment> newMap1=new HashMap<Student, Assignment>();
		
		for(Entry<Subject, Map<Student,Assignment>> e1:map.entrySet())
		{
			for(Entry<Student,Assignment> e2:e1.getValue().entrySet())
			{
//				System.out.println(e2.getValue().getMarksObtained());
				if(e2.getValue().getMarksObtained()==0)
				{
					e2.getKey().setDefaulter(true);
					newMap1.put(e2.getKey(), e2.getValue());
					newMap.put(e1.getKey(), newMap1);
//					System.out.println(newMap);
				}
			}
		}
		
		
		
		for(Entry<Subject, Map<Student, Assignment>> e:newMap.entrySet())
		{
			System.out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
		/*
		 //Map<Subject, Map<Student, Assignment>> map2=new  HashMap<Subject, Map<Student, Assignment>>();
		 for(Map.Entry<Subject,Map<Student,Assignment>> m1:map.entrySet()){
				for(Map.Entry<Student,Assignment> m2 : m1.getValue().entrySet()){
					if(m1.getKey().getSubjectName().equals(m2.getKey().getSubject())){
						long day=((m2.getValue().getSubmissionDate().getTime())-(m1.getKey().getAssignmentIssueDate().getTime()))/(1000*24*3600);
						if(day>10)
							m2.getKey().setDefaulter(true);
					}
				}
			}
		 return map;
		 */
	}

	@Override
	public void offerGraseMarks(Map<Subject, Map<Student, Assignment>> map) {
		
		/*
		 for(Map.Entry<Subject,Map<Student,Assignment>> m1:map.entrySet()){
				ArrayList<Assignment> list=new ArrayList<Assignment>();
				for(Map.Entry<Student,Assignment> m2 : m1.getValue().entrySet()){
					list.add(m2.getValue());
					Collections.sort(list,new Comparator<Assignment>(){
							public int compare(Assignment a1,Assignment a2){
						return a1.getSubmissionDate().compareTo(a2.getSubmissionDate());
							}});}
				for(Map.Entry<Student,Assignment> m2 : m1.getValue().entrySet()){
				Date d=list.get(0).getSubmissionDate();
				if(m2.getValue().getSubmissionDate().equals(d)){
					m2.getValue().setMarksObtained(m2.getValue().getMarksObtained()+3);
				}
				}
				}
		*/
	}	
}