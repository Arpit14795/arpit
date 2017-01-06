
/*
 * Author :Snehal Patil,Nagpur
 * Email  :snehalpatil2011@gmail.com
 * 
 * Disclaimer :The projects questions does not have any resemblance
 *  			with the actual exam.Though they are on the same pattern 
 *  			that I have experienced in practice assignmets.It contains the ".rtf file" 
 *  			which describes the problem statement .
 *  
 *  In case of violation of Any privacy or rights please inform
 *  
 *  
 *                "Practice makes a man perfect.................... and women too"
 */



package com.psl.bean;

import java.io.Serializable;

public class Channel implements Serializable{

	private static final long serialVersionUID = -2640065012494322364L;
	private String channelId;
	private String channelName;
	private ChannelCategory category;
	private double cost;
	private double billAmount;
	
	
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public ChannelCategory getCategory() {
		return category;
	}
	public void setCategory(ChannelCategory category) {
		this.category = category;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	
	
	
}
