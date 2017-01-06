
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

import com.psl.bean.Channel;
import com.psl.bean.ChannelCategory;

public interface SetTopBoxManagementSysytem {
	
	List<Channel> populateByChannelCategory(String fileNameChannel);
	void calculateBillForEachChannel(List< Channel> list,String fileNameUsage);
	List<Channel> sortByHighestHourOfUsage(List<Channel> list,String fileNameUsage);
	List<Channel> getByCategory(List<Channel> list,ChannelCategory category);
	
}
