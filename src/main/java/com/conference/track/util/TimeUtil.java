package com.conference.track.util;

import java.util.StringTokenizer;

import com.conference.track.exception.InvalidTimeException;

/**
 * In order to avoid using Java Time libraries this utility is written
 * @author abhishek
 *
 */
public class TimeUtil {
	
	private TimeUtil() {
		
	}

	/**
	 * This method converts time in required format for printing
	 * Takes time input 24 hour clock (no minutes) as integer and gives output 12 hour clock as String 
	 * in required PRINTABLE format
	 * Future extension should time is within range of 0 to 24 and throw exception if not
	 * @param time
	 * @throws InvalidTimeException 
	 */
	public static String timeConverter(int time) {
		String time12hrclock = "";
		
		if(time>12 && time<24) {
			time = time - 12;
			if(time > 9)
				time12hrclock = time + ":00" + "PM";
			else
				time12hrclock = "0" + time + ":00" + "PM";
		} else if(time<12){
			if(time > 9)
				time12hrclock = time + ":00" +"AM";
			else
				time12hrclock = "0" + time + ":00" + "AM";
		} else if(time == 12) {
			time12hrclock = "12:00PM";
		} else if(time == 24) {
			time12hrclock = "12:00AM";
		}else {
			// throw exception
		}
			
		return time12hrclock;
		
	}
	
	/**
	 * This method takes minutes as input and gives output in printable format
	 * Input 305 minutes will return output 05:05
	 * @param minutes
	 * @return
	 */
	public static String minsToHrs(int minutes) {
		int hrs = minutes/60;
		int minutesLeft = minutes%60;
		String hrsInString = String.valueOf(hrs);
		if(hrs < 10)
			hrsInString = "0" + hrsInString; 
		if(minutesLeft == 0)
			return hrsInString + ":" + "00";
		if(minutesLeft < 10)
			return hrsInString + ":" + "0" + minutesLeft;
		return hrsInString + ":" + minutesLeft;
	}
	
	/**
	 * This method adds two incompatible time formats such as 9 and 3:10
	 * 
	 * @return
	 */
	public static String addTime(String time1, int time2) {
		StringTokenizer st = new StringTokenizer(time1, ":");
		int hrs = Integer.parseInt(st.nextToken()) + time2;
		return hrs + ":" + st.nextToken();
	}
	
	/**
	 * The method returns the starting date of Networking event
	 * The networking event either starts at 4 PM or 5 PM depending on when evening session ends
	 * The method expects the input time in 24 hour hh:mm format 
	 * 
	 * @param comparisionDate
	 * @return
	 */
	public static String getStartTimeForNetworking(String comparisionDate) {
		StringTokenizer st = new StringTokenizer(comparisionDate, ":");
		int hrs = Integer.parseInt(st.nextToken());
		int minutes = 0;
		if(st.hasMoreTokens())
			minutes = Integer.parseInt(st.nextToken());
		if((hrs>16) || (hrs==16 && minutes>0))
			return "05:00PM";
		else
			return "04:00PM";
	}
	
}
