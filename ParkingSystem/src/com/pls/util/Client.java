package com.pls.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;
import com.pls.impl.ParkingSystemImpl;

public class Client {

	public static void main(String[] args) throws ParkingFullException, VehicleNotFoundException {
		
		ParkingSystemImpl psi=new ParkingSystemImpl();
		
		Map<ParkingSlot, List<Vehicle>> map=new HashMap<ParkingSlot, List<Vehicle>>();
		map=psi.parkVehicle("Vehicle.txt","ParkingSlot.txt");
		int count=0;
		for (Map.Entry<ParkingSlot,List<Vehicle>> mapmap:map.entrySet() )
		{
			System.out.println(mapmap.getKey());
			System.out.println(mapmap.getValue());
			count+=mapmap.getValue().size();
		}
		System.out.println(count);
		System.out.println("--------------vehicle list----------------");
		List<Vehicle> vehilist=new ArrayList<Vehicle>();
		vehilist=psi.getVehicleInLane(map, 202);
		for (Vehicle vehicle : vehilist) 
		{
			System.out.println(vehicle);
		}
		System.out.println("--------------lane no----------------");
		int lane_No=psi.locateVehicle(map,1007);
		System.out.println(lane_No);
		System.out.println("--------------removed vehicle is----------------");
		Vehicle v=psi.removeVehicle(map,1007);
		System.out.println(v);
		
		
		System.out.println("--------------after vehicle remove ----------------");
		for (Map.Entry<ParkingSlot,List<Vehicle>> mapmap:map.entrySet() )
		{
			System.out.println(mapmap.getKey());
			System.out.println(mapmap.getValue());
		}
	}

}