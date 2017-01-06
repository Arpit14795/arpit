package com.psl.main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.psl.bean.Assignment;
import com.psl.bean.Student;
import com.psl.bean.Subject;
import com.psl.util.StudentAssignment;
import com.psl.util.StudentAssignmentImpl;
public class Client {
	public static void main(String[] args) {
	StudentAssignmentImpl impl=new StudentAssignmentImpl();
	Map<Subject,Map<Student,Assignment>> map=new HashMap<Subject,Map<Student,Assignment>>();
	map=impl.populateData("subject.txt", "student.txt","submission.txt");
	
	impl.calculateMarks(map);
	
	impl.generateDefaulterListSubjectWise(map);
//	System.out.println("************START********************");
//	System.out.println(map);
//	System.out.println("********************************");
//	
//	impl.calculateMarks(map);
//	System.out.println(map);
//	System.out.println("********************************");
//
//	Map<Subject,Map<Student,Assignment>> map2=new HashMap<Subject,Map<Student,Assignment>>();
//	map2=impl.generateDefaulterListSubjectWise(map);
//	System.out.println(map2);
//	System.out.println("********************************");
//
//	impl.offerGraseMarks(map);
//	System.out.println(map);
//	System.out.println("***********END*********************");

	}
		
	}
	
	