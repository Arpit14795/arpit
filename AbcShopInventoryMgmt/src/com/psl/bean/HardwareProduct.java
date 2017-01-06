package com.psl.bean;

public class HardwareProduct extends Product {
	
	private String dimensions;
	private int capacity;
	private String brand;
	private String powerSupplyRequirement;
	private String batteryBackup;

	@Override
	public String toString() {
		return "HardwareProduct [dimensions=" + dimensions + ", capacity="
				+ capacity + ", brand=" + brand + ", powerSupplyRequirement="
				+ powerSupplyRequirement + ", batteryBackup=" + batteryBackup
				+ ", toString()=" + super.toString() + "]";
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPowerSupplyRequirement() {
		return powerSupplyRequirement;
	}

	public void setPowerSupplyRequirement(String powerSupplyRequirement) {
		this.powerSupplyRequirement = powerSupplyRequirement;
	}

	public String getBatteryBackup() {
		return batteryBackup;
	}

	public void setBatteryBackup(String batteryBackup) {
		this.batteryBackup = batteryBackup;
	}

	public HardwareProduct() {
		// TODO Auto-generated constructor stub
	}

}
