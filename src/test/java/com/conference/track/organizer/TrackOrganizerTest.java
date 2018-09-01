package com.conference.track.organizer;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.conference.track.domain.Event;
import com.conference.track.domain.Track;
import com.conference.track.util.Constants;

public class TrackOrganizerTest {

	Map<String, Integer> talksMap = new HashMap<String, Integer>();
	TalksOrganizer talksOrganizer;
	TrackOrganizer trackOrganizer;
	
	@Before
	public void setUp() throws Exception {
		
		talksOrganizer = new FIFOTalksOrganizer();
		trackOrganizer = new TrackOrganizer(talksOrganizer);
		
		talksMap.put("A", 60);
		talksMap.put("B", 60);
		talksMap.put("C", 60);
		talksMap.put("D", 60);
		talksMap.put("E", 60);
		talksMap.put("F", 60);
		talksMap.put("G", 60);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testCreateLunchEvent() {
		Event event = trackOrganizer.createLunchEvent();
		assertNotNull(event);
		assertEquals("12:00PM", event.getStartTime());
		assertEquals(Constants.EVENT_LUNCH_BREAK, event.getName());
		assertEquals(Constants.EVENT_LUNCH_LENGTH, event.getLength());
	}
	
	@Test
	public void testCreateNetworkingEvent() {
		Event event = trackOrganizer.createNetworkingEvent("16:45");
		assertNotNull(event);
		assertEquals("05:00PM", event.getStartTime());
		assertEquals(Constants.EVENT_NETWORKING, event.getName());
		assertEquals(Constants.EVENT_NETWORKING_LENGTH, event.getLength());
	}

	@Test
	public void testCreateTrack() throws Exception {
		
		Track track = trackOrganizer.createTrack(talksMap);
		assertNotNull(track);
		assertNotNull(track.getMorningSession());
		assertNotNull(track.getEveningSession());
		assertNotNull(track.getMorningSession().getTalksList());
		assertEquals("09:00AM", track.getMorningSession().getStartTime());
		assertEquals("01:00PM", track.getEveningSession().getStartTime());
		assertNotSame(track.getMorningSession(), track.getEveningSession());
		
	}

}
