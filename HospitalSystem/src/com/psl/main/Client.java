



package com.psl.main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.psl.bean.Doctor;
import com.psl.bean.Hospital;
import com.psl.bean.Speciality;
import com.psl.util.HospitalInformationSystem;
import com.psl.util.HospitalInformationSystemImpl;


public class Client {

	public static void main(String[] args) {
	
		HospitalInformationSystem impl=new HospitalInformationSystemImpl();
		Map<Hospital, Set<Doctor>> map=impl.readAllHospital("hospital.ser", "doctor.ser");
	}
}

