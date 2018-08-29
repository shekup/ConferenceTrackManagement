package com.conference.track;

import org.junit.Test;

import com.conference.track.service.ConferenceService;
import com.conference.track.util.Parser;

/**
 * Unit test for simple App.
 */
public class ApplicationTest {
	
	@Test
	public void systemUnderTest() throws Exception {
		String inputFile = "Input.txt";
		ConferenceService conferenceService = new ConferenceService();
		conferenceService.createTacksFromInput(inputFile);
		Parser.talksmap.clear();
	}
}
