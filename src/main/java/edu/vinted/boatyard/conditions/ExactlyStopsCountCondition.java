package edu.vinted.boatyard.conditions;

import edu.vinted.boatyard.entities.Path;

/**
 * Class represents condition when result must have exact count of stops
 * 
 * @author mciziunas
 *
 */
public class ExactlyStopsCountCondition implements Condition {

	private int numberOfStops;
	private String destination;
	private String source;
	
	public ExactlyStopsCountCondition(int numberOfStops, String source, String destination) {
		this.numberOfStops = numberOfStops;
		this.destination = destination;
		this.source = source;
	}

	public boolean isConditionValid(Path path) {
		if (isNotNull(path)) {
			int stopsCount = getStopsCount(path);
			return stopsCount <= this.numberOfStops;
		}
		return false;
	}

	public boolean isElementValid(Path path) {
		if (isNotNull(path)) {
			int stopsCount = getStopsCount(path);
			if (destination.equals(path.getVisitedSuburbs().getLast())) {
				return stopsCount == this.numberOfStops;
			}
			return false;
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
	
	private int getStopsCount(Path path) {
		return path.getVisitedSuburbs().size() - 1;
	}

	private boolean isNotNull(Path path) {
		return path != null && path.getVisitedSuburbs() != null;
	}
}
