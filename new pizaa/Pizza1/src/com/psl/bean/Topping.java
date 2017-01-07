package com.psl.bean;

import java.util.List;

public class Topping{

	private int Keyid;
    private int ToppingId;
	private String ToppingName;
	private double timeToCook;
	
	
	public int getKeyId() {
		return Keyid;
	}
	public void setKeyid(int Keyid) {
		this.Keyid = Keyid;
	}
	public int getToppingId() {
		return ToppingId;
	}
	public void setToppingId(int ToppingId){
		this.ToppingId = ToppingId;
	}
	public String getToppingName() {
		return ToppingName;
	}
	public void setToppingName(String ToppingName){
		this.ToppingName = ToppingName;
	}
	
	public double getTimeToCook() {
		return timeToCook;
	}
	public void setTimeToCook(double timeToCook) {
		this.timeToCook = timeToCook;
	}
	@Override
	public String toString() {
		return "Topping [Keyid=" + Keyid + ", ToppingId=" + ToppingId
				+ ", ToppingName=" + ToppingName + ", timeToCook=" + timeToCook
				+ "]";
	}
	
	
	
	
	
}
