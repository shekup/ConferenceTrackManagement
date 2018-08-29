package com.conference.track.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeUtilTest {

	@Test
	public void timeConverter_24hrGiven_12hrReturn() {
		assertEquals("01:00AM", TimeUtil.timeConverter(1));
		assertEquals("11:00AM", TimeUtil.timeConverter(11));
		assertEquals("12:00PM", TimeUtil.timeConverter(12));
		assertEquals("11:00PM", TimeUtil.timeConverter(23));
		assertEquals("12:00AM", TimeUtil.timeConverter(24));
	}

	@Test
	public void minsToHrs_minsGiven_HHMMFormatReturn() {
		assertEquals("05:05", TimeUtil.minsToHrs(305));
	}

	@Test
	public void addTime_differentFormatsGiven_HHMMFormatReturn() {
		assertEquals("12:10", TimeUtil.addTime("3:10",9));
	}

	@Test
	public void getStartTimeForNetworking_givenEveningSessionEndTime() {
		assertEquals("04:00PM", TimeUtil.getStartTimeForNetworking("15:10"));
		assertEquals("05:00PM", TimeUtil.getStartTimeForNetworking("16:10"));
	}

}
