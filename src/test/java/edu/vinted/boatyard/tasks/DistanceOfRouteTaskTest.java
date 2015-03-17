package edu.vinted.boatyard.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DistanceOfRouteTaskTest extends TestTask {

	private DistanceOfRouteTask testee;
	
	@Before
	public void setUp() {
		buildVeniceSuburbs();
	}

	@Test
	public void computeSuccess() {
		// given city with suburbs BA15 and AC10
		// given task to find distance for path 'B', 'A'
		testee = new DistanceOfRouteTask("B", "A");

		// when compute 'route distance'task
		testee.compute(city);

		// then distance of the path is equal to '15'
		Assert.assertEquals("Error in computing distance",
				"15", testee.getResult());
	}

	@Test
	public void computeNoSuch() {
		// given city with suburbs BA15 and AC10
		// given task to find distance for path 'B', 'E'
		testee = new DistanceOfRouteTask("B", "E");

		// when compute 'route distance'task
		testee.compute(city);

		// then 'NO SUCH ROUTE' message is returned
		Assert.assertEquals("Error in finding suburbs", NO_SUCH_ROUTE_MESSAGE,
				testee.getResult());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void computeNoNull() {
		// given city with suburbs BA15 and AC10
		// given task to find distance for path 'B', 'E'
		testee = new DistanceOfRouteTask();

		// when compute 'route distance'task
		testee.compute(city);
		
		//we get IllegalArgumentException. Failure if passed
		Assert.fail("Exception should be thrown");
	}

}
