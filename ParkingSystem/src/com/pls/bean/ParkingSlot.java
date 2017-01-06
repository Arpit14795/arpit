package com.pls.bean;

public class ParkingSlot implements Comparable<ParkingSlot>{
	private int slotLaneNo;
	private int price;
	private int secondPrice;
	private boolean b=true;

	public ParkingSlot() {
		super();
	}

	public ParkingSlot(int slotLaneNo, int price) {
		super();
		this.slotLaneNo = slotLaneNo;
		this.price = price;
		if(slotLaneNo==204)
		{
			secondPrice=40;
			b=false;
		}
	}
public boolean getB()
{
	return b;
}
	public int getSlotLaneNo() {
		return slotLaneNo;
	}
	public int getSecondPrice() {
		return secondPrice;
	}
	public void setSlotLaneNo(int slotLaneNo) {
		this.slotLaneNo = slotLaneNo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString()
	{
		return "[Lno"+slotLaneNo+",Price="+price+"]";
	}

	
	@Override
	public int compareTo(ParkingSlot o) {
		return this.slotLaneNo-o.slotLaneNo;
	}

}
