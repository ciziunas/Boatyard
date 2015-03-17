package edu.vinted.boatyard.conditions;

import edu.vinted.boatyard.entities.Path;

/**
 * Class represents condition which calculates and evaluates max distance between suburbs
 * 
 * @author mciziunas
 *
 */
public class MaxDistanceCondition implements Condition {
	
	private int maxDistance;
	private String destination;
	private String source;
	
	public MaxDistanceCondition(int maxDistance, String source, String destination) {
		this.maxDistance = maxDistance;
		this.destination = destination;
		this.source = source;
	}

	@Override
	public boolean isElementValid(Path path) {
		return destination.equals(path.getVisitedSuburbs().getLast());
	}

	@Override
	public boolean isConditionValid(Path path) {
		return (path.getDistance() < maxDistance);
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
