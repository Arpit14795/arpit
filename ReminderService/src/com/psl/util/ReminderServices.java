package com.psl.util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.psl.bean.Employee;
import com.psl.bean.EventEnum;
import com.psl.exception.InvalidDayException;

public interface ReminderServices {
	List<Employee> fetchAllEmployeeDetails();
	StringBuffer fetchEventMessage(String fileName);
	Map<EventEnum, Set<Employee>> fetchEventDetails(List<Employee> empList,Date date) throws InvalidDayException;
	void sortEmployeesByName(Set<Employee> empSet);
	int calculateEventYears(Date eventDate, Date sysDate) throws Exception;
	Map<EventEnum,List<StringBuffer>> employeeWishContent(Map<EventEnum, Set<Employee>> empListMap,StringBuffer msg);

}
