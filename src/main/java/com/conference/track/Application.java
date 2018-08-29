package com.conference.track;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.conference.track.exception.InvalidInputException;
import com.conference.track.service.ConferenceService;
import com.conference.track.util.Parser;

/**
 * Hello world!
 *
 */
public class Application 
{
    public static void main( String[] args )
    {
    	Scanner scanner = new Scanner( System.in );
    	try {
    		System.out.println( "********** CONFERENCE TRACK MANAGEMENT **********" );
    		System.out.println("Please provide file with input");
    		String inputFile = scanner.nextLine();
    		ConferenceService conferenceService = new ConferenceService();
    		conferenceService.createTacksFromInput(inputFile);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (InvalidInputException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			scanner.close();
		}
    }
}
