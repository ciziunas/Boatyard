package edu.vinted.boatyard.tasks;

import edu.vinted.boatyard.entities.City;
import edu.vinted.boatyard.entities.Route;
import edu.vinted.boatyard.entities.Suburb;
import edu.vinted.boatyard.entities.Task;

/**
 * This task computes the distance of the path, given in constructor as String
 * array
 * 
 * @author mciziunas
 *
 */
public class DistanceOfRouteTask extends Task {

	private String[] inputRoute;

	public DistanceOfRouteTask(String... inputRoute) {
		if (inputRoute == null || inputRoute.length < 2) {
			throw new IllegalArgumentException(
					"DistanceOfRouteTask must have 2 suburbs at least");
		}
		this.inputRoute = inputRoute;
	}

	@Override
	public void compute(City city) {
		Suburb currentSuburb = city.getSuburb(inputRoute[0]);
		Double distance = 0d;
		for (int i = 1; i < inputRoute.length; i++) {
			Suburb targetSuburb = new Suburb(inputRoute[i]);
			Route route = city.getRouteBetweenSuburbs(currentSuburb,
					targetSuburb);
			if (route != null) {
				distance += route.getDistance();
			} else {
				return;
			}
			currentSuburb = targetSuburb;
		}
		setFormatResult(distance);
	}
	
	private void setFormatResult(Double distance) {
		setResult(String.format("%f", Math.floor(distance)).split("\\,")[0]);
	}

}
