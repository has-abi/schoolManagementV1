package com.sm.schoolManagement.service.util;

import java.util.Date;

public class DateUtil {
	
	//compare two dates
	public static int compateDates(Date date1,Date date2) {
		int result = date1.compareTo(date2);
		if(result>0) return 1;
		else if(result<0) return -1;
		else return 0;
	}
}
