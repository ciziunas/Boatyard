package edu.vinted.boatyard.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.vinted.boatyard.conditions.ExactlyStopsCountCondition;
import edu.vinted.boatyard.conditions.MaxDistanceCondition;
import edu.vinted.boatyard.conditions.MaxStopsCondition;

public class NumberOfRoutesTaskTest extends TestTask {

	public static String NUMBER_OF_ROUTES = "1";
	private NumberOfRoutesTask testee;

	@Before
	public void setUp() {
		buildVeniceSuburbs();
	}

	@Test
	public void computeSuccessMaxStopsCondition() {
		// given city with suburbs BA15 and AC10
		// given task to find number of routes for path 'B', 'C', which has
		// maximum 2 stops
		testee = new NumberOfRoutesTask(new MaxStopsCondition(2, "B", "C"));

		// when compute 'number of routes' task
		testee.compute(city);

		// then the number of routes is equal '1'
		Assert.assertEquals("Error in computing route count", NUMBER_OF_ROUTES,
				testee.getResult());
	}

	@Test
	public void computeReturnsNoRoutesMaxStopsCondition() {
		// given city with suburbs BA15 and AC10
		// given task to find number of routes for path 'B', 'A', which has
		// maximum 2 stops
		testee = new NumberOfRoutesTask(new MaxStopsCondition(2, "B", "F"));

		// when compute 'number of routes' task
		testee.compute(city);

		// then number of routes is '0'
		Assert.assertEquals("Error in computing route count", "0",
				testee.getResult());
	}
	
	@Test
	public void computeReturnsNoRoutesMaxDistanceCondition() {
		// given city with suburbs BA15 and AC10
		// given task to find number of routes for path 'B', 'C', which has
		// maximum distance 2
		testee = new NumberOfRoutesTask(new MaxDistanceCondition(2, "B", "C"));

		// when compute 'number of routes' task
		testee.compute(city);

		// then number of routes is '0'
		Assert.assertEquals("Error in computing route count", "0",
				testee.getResult());
	}
	
	@Test
	public void computeSuccessMaxDistanceCondition() {
		// given city with suburbs BA15 and AC10
		// given task to find number of routes for path 'B', 'C', which has
		// maximum distance 30
		testee = new NumberOfRoutesTask(new MaxDistanceCondition(30, "B", "C"));

		// when compute 'number of routes' task
		testee.compute(city);

		// then number of routes is '1'
		Assert.assertEquals("Error in computing route count", "1",
				testee.getResult());
	}
	
	@Test
	public void computeNotExistingPathMaxDistanceCondition() {
		// given city with suburbs BA15 and AC10
		// given task to find number of routes for path 'B', 'H', which has
		// maximum distance 30
		testee = new NumberOfRoutesTask(new MaxDistanceCondition(30, "B", "H"));

		// when compute 'number of routes' task
		testee.compute(city);

		// then number of routes is '0'
		Assert.assertEquals("Error in computing route count", "0",
				testee.getResult());
	}
	
	@Test
	public void computeReturns0ExactlyStopsCountCondition() {
		// given city with suburbs BA15 and AC10
		// given task to find number of routes for path 'A', 'F', which has
		// exactly 1 stop
		testee = new NumberOfRoutesTask(new ExactlyStopsCountCondition(1, "A", "F"));

		// when compute 'number of routes' task
		testee.compute(city);

		// then number of routes is '0'
		Assert.assertEquals("Error in computing route count", "0",
				testee.getResult());
	}
	
	public void computeSuccessExactlyStopsCountCondition() {
		// given city with suburbs BA15 and AC10
		// given task to find number of routes for path 'B', 'C', which has
		// exactly 2 stop
		testee = new NumberOfRoutesTask(new ExactlyStopsCountCondition(2, "B", "C"));

		// when compute 'number of routes' task
		testee.compute(city);

		// then number of routes is '1'
		Assert.assertEquals("Error in computing route count", "1",
				testee.getResult());
	}
	
}
