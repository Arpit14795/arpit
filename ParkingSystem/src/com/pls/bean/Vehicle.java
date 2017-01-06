package com.pls.bean;


public class Vehicle {

	private int vehicleId;
	private VehicleType vehicleType;
	private int price;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(int vehicleId, VehicleType vehicleType) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		if(vehicleType.equals(VehicleType.Bike))
		    setPrice(20);
		if(vehicleType.equals(VehicleType.Bus))
			setPrice(60);
		if(vehicleType.equals(VehicleType.Car))
			setPrice(40);
		if(vehicleType.equals(VehicleType.Truck))
			setPrice(50);
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getPrice() {
		return price;
	}

	private void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", price=" + price + "]\n";
	}
	
}
