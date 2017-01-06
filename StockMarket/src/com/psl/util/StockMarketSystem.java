
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




package com.psl.util;

import java.util.List;
import java.util.Map;

import com.psl.bean.Sector;
import com.psl.bean.Stock;

public interface StockMarketSystem {

	Map<Sector,List<Stock>> readData();
	void calculateProfit(Map<Sector,List<Stock>> map);
	List<Stock> getsStockSectorwise(Map<Sector,List<Stock>> map,Sector sectorType);//list returned should be inn ascending order of purchase date
	List<Stock> stockToSell(Map<Sector,List<Stock>> map);//stocks that are older than 50 weaks and are undergoing loss
	
	
}
