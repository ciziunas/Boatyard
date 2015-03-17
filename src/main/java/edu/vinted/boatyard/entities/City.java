package edu.vinted.boatyard.entities;

import java.util.HashMap;

public class City {

	private String name;
	private HashMap<String, Suburb> suburbs = new HashMap<>();

	public City(String name) {
		this.name = name;
	}

	public boolean isSuburbInTheMap(Suburb suburb) {
		return suburbs.get(suburb) != null;
	}
	
	public Suburb addSuburb(String name) {
		Suburb suburb = suburbs.get(name);
		if (suburb == null) {
			Suburb newSuburb = new Suburb(name);
			suburbs.put(name, newSuburb);
			return newSuburb;
		}
		return suburb;
	}
	
	public String getName() {
		return name;
	}

	public Suburb getSuburb(String name) {
		return suburbs.get(name);
	}
	
	public Suburb getSuburb(Suburb suburb) {
		return (suburb != null ? getSuburb(suburb.getName()) : null);
	}

	public HashMap<String, Suburb> getSuburbs() {
		return suburbs;
	}
	
	public Route getRouteBetweenSuburbs(Suburb currentSuburb, Suburb targetSuburb) {
		Suburb existingSuburb = getSuburb(currentSuburb);
		if (existingSuburb == null) return null;
		for (Route route : existingSuburb.getRoutes()) {
			if (route.getTarget().equals(targetSuburb)) {
				return route;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "City[name: "+ name + "]";
	}
}
