package com.psl.bean;

import java.util.List;

public class Topping{

	private int Keyid;
    private int ToppingId;
	private String ToppingName;
	private double timeToCook;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Keyid;
		result = prime * result + ToppingId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topping other = (Topping) obj;
		if (Keyid != other.Keyid)
			return false;
		if (ToppingId != other.ToppingId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nTopping [Keyid=" + Keyid + ", ToppingId=" + ToppingId
				+ ", ToppingName=" + ToppingName + ", timeToCook=" + timeToCook
				+ "]";
	}
	public Topping(int keyid, int toppingId, String toppingName,
			double timeToCook) {
		super();
		Keyid = keyid;
		ToppingId = toppingId;
		ToppingName = toppingName;
		this.timeToCook = timeToCook;
	}
	public Topping() {
		// TODO Auto-generated constructor stub
	}
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
	
	
	
	
	
}
