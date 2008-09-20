package com.crocus.examples.csv.fields;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright:
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
public class StringField implements CSVField {

	private String value = null;

	/**
	 * 
	 * @param value
	 *            String
	 */
	public StringField(String value) {
		this.value = value;
	}

	/**
	 * 
	 * @return int
	 */
	public int getType() {
		return FieldConstants.STRING;
	}

	/**
	 * 
	 * @return Object
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * 
	 * @return String
	 */
	public String getString() {
		return value;
	}

	/**
	 * 
	 * @return String
	 */
	public String toString() {
		return value;
	}

}
