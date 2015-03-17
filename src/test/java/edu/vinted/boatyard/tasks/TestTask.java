package edu.vinted.boatyard.tasks;

import edu.vinted.boatyard.entities.City;
import edu.vinted.boatyard.entities.Route;
import edu.vinted.boatyard.entities.Suburb;

public abstract class TestTask {
	
	protected static final String CITY_NAME = "Venice";
	protected static final String SUBURB_A = "A";
	protected static final String SUBURB_B = "B";
	protected static double BA_DISTANCE = 15d;
	protected static double AC_DISTANCE = 10d;
	protected static final String NO_SUCH_ROUTE_MESSAGE = "NO SUCH ROUTE";
	protected City city;
	
	protected void buildVeniceSuburbs() {
		city = new City(CITY_NAME);
		Suburb a = city.addSuburb(SUBURB_A);
		Route baRoute = new Route(a);
		baRoute.setDistance(BA_DISTANCE);

		Suburb b = city.addSuburb(SUBURB_B);
		b.addRoute(baRoute);

		Suburb c = city.addSuburb("C");
		Route acRoute = new Route(c);
		acRoute.setDistance(AC_DISTANCE);
		a.addRoute(acRoute);
	}


}
