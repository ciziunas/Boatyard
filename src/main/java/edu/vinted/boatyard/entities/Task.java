package edu.vinted.boatyard.entities;

import edu.vinted.boatyard.conditions.Condition;

/**
 * This is a base class for task. Task has its condition and result. Compute
 * method must be implemented in every task for computing the result
 * 
 * @author mciziunas
 *
 */
public abstract class Task {

	public static final String ERROR_MESSAGE = "NO SUCH ROUTE";

	private String result = ERROR_MESSAGE;
	private Condition condition;

	public abstract void compute(City city);

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	protected Condition getCondition() {
		return condition;
	}

	protected void setCondition(Condition condition) {
		this.condition = condition;
	}

}
