package com.mpc.util;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.mpc.*;
import com.mpc.bean.Employee;
import com.mpc.bean.SpecialDays;


public interface EmpImp 
{
    List<Employee> populateDataFromDb();
    int findAge(Date birthdate);
    Map<SpecialDays, List<Employee>> checkWeekDays(List<Employee> list);
    StringBuffer readfromFile(String file);
    Map<SpecialDays, List<StringBuffer>> greetingmsg(Map<SpecialDays, List<Employee>> map,StringBuffer s);
    
}
