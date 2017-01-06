package com.psl.bean;

public class Price {

	private int ToppingId;
	private double cost;
	
	
	@Override
	public String toString() {
		return "\nPrice [ToppingId=" + ToppingId + ", cost=" + cost + "]";
	}
	public int getToppingId() {
		return ToppingId;
	}
	public void setToppingId(int ToppingId){
		this.ToppingId = ToppingId;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
