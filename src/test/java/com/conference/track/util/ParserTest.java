package com.conference.track.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.conference.track.exception.InvalidInputException;

public class ParserTest {

	Map<String, Integer> talksmap;
	
	@Before
	public void setUp() throws Exception {
		talksmap = new LinkedHashMap<String, Integer>();
		talksmap.put("Woah", 30);
	}

	@After
	public void tearDown() throws Exception {
		talksmap = null;
	}

	@Test
	public void testParseInput() {
		
	}

	@Test
	public void testStringContainsNumber() {
		assertEquals(true, Parser.stringContainsNumber("Woah 30min"));
		assertEquals(false, Parser.stringContainsNumber("Woah"));
	}

	@Test
	public void testParseInputLine() {
		try {
			Parser.parseInputLine("Woah 30min");
			assertThat(talksmap, is(Parser.talksmap));
		} catch (InvalidInputException e) {
			fail(e.getMessage());
		}
		
	}

}
