package com.psl.bean;

import com.psl.enums.OperatingSystem;

public class SoftwareProduct extends Product {

	private OperatingSystem operatingSystem;
	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	private String memory;
	private String licenceKe;
	@Override
	public String toString() {
		return "SoftwareProduct [operatingSystem=" + operatingSystem
				+ ", memory=" + memory + ", licenceKe=" + licenceKe
				+ ", toString()=" + super.toString() + "]";
	}
	
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getLicenceKe() {
		return licenceKe;
	}
	public void setLicenceKe(String licenceKe) {
		this.licenceKe = licenceKe;
	}
	public SoftwareProduct() {
		// TODO Auto-generated constructor stub
	}

}
