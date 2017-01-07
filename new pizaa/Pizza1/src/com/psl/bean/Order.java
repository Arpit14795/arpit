package com.psl.bean;

public class Order {

	
	private int Keyid;
	private int ToppingId;
    private String ToppingName;
	private String size;
	private double cost = 0;
	
	
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
	public String getsize() {
		return size;
	}
	public void setsize(String size){
		this.size = size;
	}	

	public String getToppingName() {
		return ToppingName;
	}
	public void setToppingName(String ToppingName){
		this.ToppingName = ToppingName;
	}	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Order [Keyid=" + Keyid + ", ToppingId=" + ToppingId
				+ ", ToppingName=" + ToppingName + ", size=" + size + ", cost="
				+ cost + "]"+"\n";
	}
		
	
}


