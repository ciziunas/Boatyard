package edu.vinted.boatyard.entities;

public class Route {
	
	private Double distance;
	private Suburb target;
	
	public Route(Suburb target) {
		this.target = target;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Suburb getTarget() {
		return target;
	}

	public void setTarget(Suburb target) {
		this.target = target;
	}
	
}
