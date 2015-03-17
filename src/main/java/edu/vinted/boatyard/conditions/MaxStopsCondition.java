package edu.vinted.boatyard.conditions;

import edu.vinted.boatyard.entities.Path;

/**
 *  Class represents condition which count and evaluates max stops count
 *  
 * @author mciziunas
 *
 */
public class MaxStopsCondition implements Condition {
	
	private int numberOfStops;
	private String destination;
	private String source;
	
	public MaxStopsCondition(int numberOfStops, String source, String destination) {
		this.numberOfStops = numberOfStops;
		this.destination = destination;
		this.source = source;
	}

	@Override
	public boolean isElementValid(Path path) {
		return destination.equals(path.getVisitedSuburbs().getLast());
	}

	@Override
	public boolean isConditionValid(Path path) {
		if (path != null && path.getVisitedSuburbs() != null) {
			int stopsCount = path.getVisitedSuburbs().size() - 1;
			return stopsCount <= this.numberOfStops;
		}
		return false;
	}

	@Override
	public String getSource() {
		return this.source;
	}

	@Override
	public String getDestination() {
		return this.destination;
	}

}
