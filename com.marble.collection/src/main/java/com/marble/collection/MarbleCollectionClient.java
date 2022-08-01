package com.marble.collection;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

// Rest client to call the methods exposed in the service
public class MarbleCollectionClient {
	
	public static void main(String[] args)  {
		try {
			
			/**
			 * Deployment Strategy: 
			 * 
			 *  We will build a Rest web-service which will listen to the requests, Filters the List and returns back the filtered list in the response.
			 *  
			 *  I will choose "In-Place" deployment strategy since it is cost efficient and reliable.
			 *  
			 *  If the records are a million count, then i will implement a logic to utilize threading, dynamic approach or Greedy algorithmic approach to find the shortest path.
			 */
			
			// Test-1: Reading Json file and then send the list as input to the method exposed by service
			Instant start = Instant.now();
			List<MarbleDTO> marblesList = new ArrayList<MarbleDTO>();
			ObjectMapper mapper = new ObjectMapper();
			marblesList = mapper.readValue(new File(MarbleCollectionClient.class.getClassLoader().getResource("marbles.json").toURI()), new TypeReference<List<MarbleDTO>>() {});
			// Sending the prepared list to the exposed method
			new MarbleCollectionService().getFilteredList(marblesList);
			Instant end = Instant.now();
			System.out.println("End of Test-1: " + Duration.between(start, end));
			
			
			
			
			
			// Test-2: send the Json as input to the method exposed by service (Original way)
			start = Instant.now();
			String jsonObject = "\r\n"
					+ "[\r\n"
					+ "	{ \"id\": 1, \"color\": \"blue\", \"name\": \"Bob\", \"weight\": 0.5 },\r\n"
					+ "	{ \"id\": 2, \"color\": \"red\", \"name\": \"John Smith\", \"weight\": 0.25 },\r\n"
					+ "	{ \"id\": 3, \"color\": \"violet\", \"name\": \"Bob O'Bob\", \"weight\": 0.5 },\r\n"
					+ "	{ \"id\": 4, \"color\": \"indigo\", \"name\": \"Bob Dad-Bob\", \"weight\": 0.75 },\r\n"
					+ "	{ \"id\": 5, \"color\": \"yellow\", \"name\": \"John\", \"weight\": 0.5 },\r\n"
					+ "	{ \"id\": 6, \"color\": \"orange\", \"name\": \"Bob\", \"weight\": 0.25 },\r\n"
					+ "	{ \"id\": 7, \"color\": \"blue\", \"name\": \"Smith\", \"weight\": 0.5 },\r\n"
					+ "	{ \"id\": 8, \"color\": \"blue\", \"name\": \"Bob\", \"weight\": 0.25 },\r\n"
					+ "	{ \"id\": 9, \"color\": \"green\", \"name\": \"Bobb Ob\", \"weight\": 0.75 },\r\n"
					+ "	{ \"id\": 10, \"color\": \"blue\", \"name\": \"Bob\", \"weight\": 0.5 }\r\n"
					+ "]\r\n"
					+ "";
			// assuming we send the Json as input to the Service
			new MarbleCollectionService().getFilteredList(jsonObject);
			end = Instant.now();
			System.out.println("End of Test-2: " + Duration.between(start, end));
			
			
    } catch (Exception e) {
    	System.out.println(e);
    }
}
}