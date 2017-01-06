
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

import java.sql.Date;

public class Stock {

	private String stockName;
	private Sector sectorType;
	private double costPrice;
	private double presentPrice;
	private Date purchaseDate;
	private int numberOfShares;
	private double totalProfit;
	
	
	
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Sector getSectorType() {
		return sectorType;
	}
	public void setSectorType(Sector sectorType) {
		this.sectorType = sectorType;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getPresentPrice() {
		return presentPrice;
	}
	public void setPresentPrice(double presentPrice) {
		this.presentPrice = presentPrice;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public double getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	
	
	
	
	
	
}
