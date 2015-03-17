package edu.vinted.boatyard.entities;

import java.util.LinkedList;

public class Suburb implements Comparable<Suburb> {

	private LinkedList<Route> routes = new LinkedList<>();
	private Double distance = 0d;
	private String name;

	public Suburb(String name) {
		this.name = name;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public LinkedList<Route> getRoutes() {
		return routes;
	}

	public void addRoute(Route route) {
		this.routes.add(route);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Suburb)) {
			return false;
		}
		Suburb other = (Suburb) obj;
		if (other.getName().equals(this.getName())) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Suburb target) {
		return this.getDistance().compareTo(target.getDistance());
	}
	
}
