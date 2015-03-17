package edu.vinted.boatyard;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.vinted.boatyard.entities.City;
import edu.vinted.boatyard.services.DataService;
import edu.vinted.boatyard.services.TaskService;

public class Main {

	private static final String DATA_FILE_NAME = "venice.txt";
	private static final String CITY_NAME = "Venice";

	private static City city;

	/**
	 * Main class of suburbs application. Application generates 10 tasks and
	 * computes the result for them. Tasks include shortest route, number and
	 * distance of route tasks. Tasks are implemented for distances and numbers
	 * of Venice suburbs counting.
	 * 
	 * @param args
	 *            are the parameters passed from OS. The first parameter is the
	 *            path of input data file
	 * @throws FileNotFoundException
	 *             is thrown if input file is not found
	 * @throws IOException
	 *             if there is a problem while reading data file
	 */
	public static void main(String... args) throws FileNotFoundException,
			IOException {
//		String filename = args[0];
		city = DataService.populateMap(CITY_NAME, DATA_FILE_NAME);
		TaskService.buildTasks();
		TaskService.computeTasks(city);
		TaskService.printResults();
	}
}