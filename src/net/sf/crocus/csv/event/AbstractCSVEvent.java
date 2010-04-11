package net.sf.crocus.csv.event;

import java.util.EventObject;

public abstract class AbstractCSVEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9097493627600526446L;

	public AbstractCSVEvent(Object source) {
		super(source);
	}

}
