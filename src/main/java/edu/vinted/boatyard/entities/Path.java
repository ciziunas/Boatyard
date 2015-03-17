package edu.vinted.boatyard.entities;

import java.util.Deque;
import java.util.LinkedList;

public class Path {
	
	private Deque<String> visitedSuburbs = new LinkedList<>();
	private Double distance = new Double(0);
	
	public Path(Path path) {
		visitedSuburbs = new LinkedList<>(path.visitedSuburbs);
		distance = path.getDistance();
	}

	public Path(Suburb entryPoint) {
		addSuburb(entryPoint);
	}

	public Deque<String> getVisitedSuburbs() {
		return visitedSuburbs;
	}

	public void setVisitedSuburbs(Deque<String> visitedSuburbs) {
		this.visitedSuburbs = visitedSuburbs;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public void addDistance(Double distance) {
		this.distance += distance;
	}
	
	public void addSuburb(Suburb suburb) {
		visitedSuburbs.add(suburb.getName());
		
	}
}
