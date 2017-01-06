

package com.psl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;

public class HospitalInformationSystemImpl implements HospitalInformationSystem {

	@Override
	public Map<Hospital, Set<Doctor>> readAllHospital(String fileHospital,
			String fileDoctor) {
		// TODO Auto-generated method stub
		Map<Hospital, Set<Doctor>> map=new TreeMap<Hospital,Set<Doctor>>(new Comparator<Hospital>() {

			@Override
			public int compare(Hospital arg0, Hospital arg1) {
				// TODO Auto-generated method stub
				return arg0.getHospitalId()-arg1.getHospitalId();
			}
		});
		
		ObjectInputStream ois=null;
		try {
			ois=new ObjectInputStream(new FileInputStream(new File(fileHospital)));
			while(true)
			{
				Hospital h=(Hospital)ois.readObject();
				map.put(h, new TreeSet<Doctor>(new Comparator<Doctor>() {

					@Override
					public int compare(Doctor arg0, Doctor arg1) {
						// TODO Auto-generated method stub
						return arg0.getDoctorId()-arg1.getDoctorId();
					}
					
				}));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Doctor> listDoctor=new ArrayList<Doctor>();
		ObjectInputStream ois2=null;
		try {
			ois2=new ObjectInputStream(new FileInputStream(new File(fileDoctor)));
			while(true)
			{
				Doctor d=(Doctor)ois2.readObject();
				listDoctor.add(d);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Entry<Hospital, Set<Doctor>> e:map.entrySet())
		{
			for(Doctor d:listDoctor)
			{
				if(e.getKey().getHospitalId()==d.getHospitalId())
				{
					e.getValue().add(d);
				}
			}
		}
		
		for(Entry<Hospital, Set<Doctor>> e:map.entrySet())
		{
			System.out.println(e);
		}
		
		return null;
	}

	@Override
	public Set<Doctor> getListOfDoctors(Map<Hospital, Set<Doctor>> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> eligibleForAppointment(Map<Hospital, Set<Doctor>> map,
			Speciality speciality, int experienceInDays) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getListWithinHospital(Map<Hospital, Set<Doctor>> map,
			int hospitalId, Speciality speciality, int experience) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
