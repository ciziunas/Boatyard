package edu.vinted.boatyard.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import edu.vinted.boatyard.entities.City;

public class DataServiceTest {

	@Test
	public void populateMapSuccessTest() throws FileNotFoundException, IOException {
		// given path of input file with valid data
		String dataFilePath = DataServiceTest.class.getClassLoader().getResource("venice.txt").getPath();
		
		// when populating map
		City city = DataService.populateMap("Venice", dataFilePath);
		
		// then suburbs count is 5
				Assert.assertEquals("Error in populating suburbs", 5,
						city.getSuburbs().size());
	}
	
	@Test(expected = FileNotFoundException.class)
	public void populateMapFileNotFoundException() throws FileNotFoundException, IOException {
		// given invalid path
		String dataFilePath = "ven.txt";
		
		// when populating map
		DataService.populateMap("Venice", dataFilePath);
		
		// then FileNotFoundException should be thrown
		Assert.fail();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void populateMapIllegalArgumentException() throws FileNotFoundException, IOException {
		// given path of input file with invalid data
		String dataFilePath = DataServiceTest.class.getClassLoader().getResource("veniceInvalid.txt").getPath();
		
		// when populating map
		DataService.populateMap("Venice", dataFilePath);
		
		// then IllegalArgumentException should be thrown
		Assert.fail();
	}
	
}