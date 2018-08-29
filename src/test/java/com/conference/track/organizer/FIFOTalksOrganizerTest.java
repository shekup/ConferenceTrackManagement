package com.conference.track.organizer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.conference.track.domain.Talk;
import com.conference.track.exception.InvalidTalkException;

public class FIFOTalksOrganizerTest {
	
	Map<String, Integer> talksMap;
	int length = 180; // minutes
	FIFOTalksOrganizer fifoTalksOrganizer;
	List<Talk> talks; 

	@Before
	public void setUp() throws Exception {
		
		talksMap = new LinkedHashMap<String, Integer>();
		// Put 5 talks - more than boundaries of session that is length
		talksMap.put("Java", 60);
		talksMap.put("Python", 45);
		talksMap.put("Machines", 45);
		talksMap.put("Intelligence", 30);
		talksMap.put("IOT", 30);
		
		fifoTalksOrganizer = new FIFOTalksOrganizer();
		
	}

	@After
	public void tearDown() throws Exception {
		
		talksMap = null;
		fifoTalksOrganizer = null;
	}

	@Test
	public void testOrganize() {
		try {
			talks = fifoTalksOrganizer.organize(talksMap, length);
			assertEquals(4, talks.size());
			assertEquals("Java", talks.get(0).getTitle());
			assertEquals("Python", talks.get(1).getTitle());
			assertEquals("Machines", talks.get(2).getTitle());
			assertEquals("Intelligence", talks.get(3).getTitle());
		} catch (InvalidTalkException e) {
			System.out.println(e.getMessage());
		}
	}

}
