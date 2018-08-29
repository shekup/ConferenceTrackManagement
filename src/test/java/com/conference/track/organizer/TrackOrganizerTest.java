package com.conference.track.organizer;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.conference.track.domain.Track;

public class TrackOrganizerTest {

	Map<String, Integer> talksMap = new HashMap<String, Integer>();
	
	@Before
	public void setUp() throws Exception {
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
	public void testCreateTrack() throws Exception {
		
		TalksOrganizer talksOrganizer = new FIFOTalksOrganizer();
		TrackOrganizer trackOrganizer = new TrackOrganizer(talksOrganizer);
		Track track = trackOrganizer.createTrack(talksMap);
		assertNotNull(track);
		assertNotNull(track.getMorningSession());
		assertNotNull(track.getLunch());
		assertNotNull(track.getEveningSession());
		assertNotNull(track.getNetworking());
		assertNotNull(track.getMorningSession().getTalksList());
		assertEquals("09:00AM", track.getMorningSession().getStartTime());
		assertEquals("12:00PM", track.getLunch().getStartTime());
		assertEquals("05:00PM", track.getNetworking().getStartTime());
		assertNotSame(track.getMorningSession(), track.getEveningSession());
		
	}

}
