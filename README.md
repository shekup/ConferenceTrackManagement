Conference Track Management
The program plans the conference track for a day.  The program is developed using Java and Maven inside Eclipse IDE.  The design of program is depicted in an image

Installing
The package consists of following:
1. src - The source code in java of the program
2. pom.xml - Maven configuration file
3. Input.txt - A text file with sample input

Put all three in one location and run maven command: "mvn clean install".   The program has a test case that tests the input file and it might fail if program is unable to locate the Input.txt.  If build fails then please use command: "mvn clean install -DskipTests"

The program can be imported in any IDE including Eclipse and run from there. 

Running
The target folder has executable jar file.  If running from "cd target" and run command "java -jar track-0.0.1-SNAPSHOT.jar".  The program asks for the location and name of the file with input, enter the file name with complete path.  If running inside IDE, then locate the file "Application.java" and run the file as Java Application. 

Insights
1. "Application.java" takes the input file and instantiates "ConferenceService"  
2. "ConferenceService" delegates the parsing of input to "Parser", which prepares a Map of talk title and talk length.  Parser maintains insertion order in Map
3. ConferenceService chooses the "TalkOrganizer" (FIFO, Alphabetical, etc.)  and passes to "TrackOrganizer"  
4. "TrackOrganizer" gets Talk Map<title,length> as input 
5. "TrackOrganizer" asks "TalkOrganizer" to organize talks for each session (morning and evening) one by one
6. "TalkOrganizer" will create instances of object "Talk" for each entry in Talk Map and select talks for the session  
7. "TrackOrganizer" will instantiate the "Track" object and set sessions in Track
8. "TrackOrganizer" will set two events: "Lunch" and "Networking" in "Track" object

Future
Conference will invoke TrackOrganizer multiple times passing different organizing algorithms (implementations of TalkOrganizer" to create multiple tracks.  Each track will have an efficiency associated so that best track can be chosen. 

Issues
1. The regular expression pattern to validate input line is copied from Internet and might fail
2. No logger is attached and output comes on console

More details: 
http://shekup.blogspot.com/2018/09/conference-track-management.html



