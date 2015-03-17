package edu.vinted.boatyard.tasks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShortestRouteTaskTest extends TestTask {

	public static String INFINITY = "Infinity";
	private ShortestRouteTask testee;

	@Before
	public void setUp() {
		buildVeniceSuburbs();
	}

	@Test
	public void computeInfinity() {
		// given city with suburbs BA15 and AC10
		// given task to find the shortest route for path 'B', 'B'
		testee = new ShortestRouteTask("B", "B");

		// when compute 'shortest route' task
		testee.compute(city);

		// then we get infinity, because path to this suburb doesnt exist
		Assert.assertEquals("Error in computing route count", INFINITY,
				testee.getResult());
	}
	
	@Test
	public void computeSuccess() {
		// given city with suburbs BA15 and AC10
		// given task to find the shortest route for path 'B', 'C'
		testee = new ShortestRouteTask("B", "C");

		// when compute 'shortest route' task
		testee.compute(city);

		// then we get 25
		Assert.assertEquals("Error in computing route count", "25",
				testee.getResult());
	}
	
	@Test
	public void computeSuccesss() {
		// given city with suburbs BA15 and AC10
		// given task to find the shortest route for path 'B', 'G'
		testee = new ShortestRouteTask("B", "G");

		// when compute 'shortest route' task
		testee.compute(city);

		// then we get "NO SUCH ROUTE" message because suburb G does not exist
		Assert.assertEquals("Error in computing route count", NO_SUCH_ROUTE_MESSAGE,
				testee.getResult());
	}
}
