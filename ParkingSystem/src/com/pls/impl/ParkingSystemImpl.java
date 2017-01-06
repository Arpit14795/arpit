package com.pls.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.pls.bean.ParkingSlot;
import com.pls.bean.Vehicle;
import com.pls.bean.VehicleType;
import com.pls.exception.ParkingFullException;
import com.pls.exception.VehicleNotFoundException;

public class ParkingSystemImpl implements ParkingSystem
{

	@Override
	public Map<ParkingSlot, List<Vehicle>> parkVehicle(String fileVehicle,
			String fileParkingSlot) throws ParkingFullException 
			{
		Map<ParkingSlot, List<Vehicle>> map=new TreeMap<ParkingSlot, List<Vehicle>>();
		List<Vehicle> list=new ArrayList<Vehicle>();
		try(Scanner sc=new Scanner(new File(fileParkingSlot)))
		{
			
			while(sc.hasNext())
			{
				String str[]=sc.nextLine().split(":");
				map.put(new ParkingSlot(Integer.parseInt(str[0].trim()), Integer.parseInt(str[1].trim())),
				new ArrayList<Vehicle>());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Scanner sc=new Scanner(new File(fileVehicle)))
		{
			while(sc.hasNext())
			{
				String str[]=sc.nextLine().split("-");
				list.add(new Vehicle(Integer.parseInt(str[0].trim()),
						VehicleType.valueOf(str[1].trim())));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count=0;
		for (Vehicle vehicle : list) 
			for (Entry<ParkingSlot, List<Vehicle>> ent : map.entrySet())
				if(vehicle.getPrice()==ent.getKey().getPrice() && ent.getValue().size()<4 && ent.getKey().getB())
				{
					ent.getValue().add(vehicle);
					count+=1;
					break;
				}
				else	if((vehicle.getPrice()==ent.getKey().getPrice() || vehicle.getPrice()==ent.getKey().getSecondPrice())
						&& ent.getValue().size()<4)
				{
					ent.getValue().add(vehicle);
					count+=1;
					break;
				}
		/*if(count<list.size())
			throw new ParkingFullException();*/
		return map;
	}

	@Override
	public List<Vehicle> getVehicleInLane(Map<ParkingSlot, List<Vehicle>> map,
			int slotLaneNo)
			{
		for (Entry<ParkingSlot, List<Vehicle>> ent : map.entrySet())
		{
				if(ent.getKey().getSlotLaneNo()==slotLaneNo)
					return ent.getValue();
		}
		return new ArrayList<Vehicle>();
			}

	@Override
	public int locateVehicle(Map<ParkingSlot, List<Vehicle>> map, int vehicleId)
			throws VehicleNotFoundException 
	{
		for (Entry<ParkingSlot, List<Vehicle>> ent : map.entrySet())
				for (Vehicle v : ent.getValue()) 
					if(v.getVehicleId()==vehicleId)
						return ent.getKey().getSlotLaneNo();
		throw new VehicleNotFoundException();
	}

	@Override
	public Vehicle removeVehicle(Map<ParkingSlot, List<Vehicle>> map,
			int vehicleId) throws VehicleNotFoundException 
	{
		for (Entry<ParkingSlot, List<Vehicle>> ent : map.entrySet()) 
		{
			ListIterator<Vehicle> i=ent.getValue().listIterator();
			while(i.hasNext())
			{
				Vehicle v=i.next();
				if(v.getVehicleId()==vehicleId)
				{
					i.remove();
					return v;
				}
			}
		}
		throw new VehicleNotFoundException();
	}

	

	
	
}
