package edu.vinted.boatyard.tasks;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import edu.vinted.boatyard.entities.City;
import edu.vinted.boatyard.entities.Route;
import edu.vinted.boatyard.entities.Suburb;
import edu.vinted.boatyard.entities.Task;

/**
 * This class computes the shortest distance from source to target suburb.
 * Dijkstra's shortest path algorithm is implemented.
 * 
 * @author mciziunas
 *
 */
public class ShortestRouteTask extends Task {

	private Suburb source;
	private Suburb target;

	public ShortestRouteTask(String source, String target) {
		this.source = new Suburb(source);
		this.target = new Suburb(target);
	}

	@Override
	public void compute(City city) {
		LinkedList<Suburb> unvisitedSuburbs = new LinkedList<>();
		prepareUnvisitedSuburbs(city, unvisitedSuburbs);
		Iterator<Suburb> itr = unvisitedSuburbs.iterator();
		Collections.sort(unvisitedSuburbs);
		boolean isEqualSourceAndTarget = true;

		while (itr.hasNext()) {
			Suburb currentSuburb = unvisitedSuburbs.poll();
			Iterator<Route> routesIt = currentSuburb.getRoutes().iterator();
			while (routesIt.hasNext()) {
				Route targetRoute = routesIt.next();
				double currentDistance = currentSuburb.getDistance()
						+ targetRoute.getDistance();
				if (currentDistance < targetRoute.getTarget()
						.getDistance()) {
					targetRoute.getTarget().setDistance(currentDistance);
				}
			}
			if (source.equals(target) && isEqualSourceAndTarget) {
				source.setDistance(Double.POSITIVE_INFINITY);
				isEqualSourceAndTarget = false;
			}
		}
		if (city.getSuburb(target) != null) {
			setFormatResult(city.getSuburb(target).getDistance());
		}
	}
	
	private void prepareUnvisitedSuburbs(City city, LinkedList<Suburb> unvisitedSuburbs) {
		for (Suburb suburb : city.getSuburbs().values()) {
			suburb.setDistance(Double.POSITIVE_INFINITY);
			unvisitedSuburbs.add(suburb);
		}
		source = city.getSuburb(source);
		source.setDistance(0d);
	}
	
	private void setFormatResult(Double distance) {
		setResult(String.format("%f", Math.floor(distance)).split("\\,")[0]);
	}

}
