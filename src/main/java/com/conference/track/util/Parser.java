package com.conference.track.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.conference.track.util.Constants;

import com.conference.track.exception.InvalidInputException;

/**
 * One rule-of-thumb: ask yourself "does it make sense to call this method, even if no Obj has been constructed yet?" 
 * If so, it should definitely be static
 * @author abhishek
 *
 */
public class Parser {
	
	public static Map<String, Integer> talksmap = new LinkedHashMap<String, Integer>();
	
	private Parser() {
		
	}
	
	public static void parseInput(String filename) throws FileNotFoundException, InvalidInputException{
		
		// 1. create a File object
	    File file = new File(filename);             
	
	    // 2. check that the file exists before trying to create a Scanner to read the file
	    if ( file.exists() )                          
	    {                                              
	                                                   
	        // 3. Create a Scanner from the file. 
	        Scanner inFile = new Scanner(file);
	        
	        // 4. Parse the file
	        while (inFile.hasNext()) {
	        	
	        	String line = inFile.nextLine();
	        	System.out.println(line);
	        	parseInputLine(line);
	        	
	        }
	        
	        inFile.close();
	        
	    }else {
	    	
	    	throw new FileNotFoundException("File does not exist");
	    	
	    }
	}

	static boolean stringContainsNumber( String s )
	{
	    Pattern p = Pattern.compile( "[0-9]" );
	    Matcher m = p.matcher( s );
	    return m.find();
	}
	
	static void parseInputLine(String line) throws InvalidInputException {
		Pattern p = Pattern.compile(Constants.INPUT_PATTERN);
		Matcher m = p.matcher(line);
		if(m.find()) {
			String one = m.group(1);
			String two = m.group(2);
			String three = m.group(3);
			int length;
			if(three.equals(Constants.TALK_LENGTH_TYPE_LIGHT))
				length = 5;
			else
				length = Integer.parseInt(two);
			talksmap.put(one, length);
		}else {
			throw new InvalidInputException("Invalid pattern in talk: " + line);
		}
	}

}
