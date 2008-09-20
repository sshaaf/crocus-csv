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
public class LongField implements CSVField {

	private long value = 0;

	public LongField(Long value) {
		this.value = value;
	}

	/**
	 * 
	 * @return int
	 */
	public int getType() {
		return FieldConstants.LONG;
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
	 * @return long
	 */
	public long getLong() {
		return value;
	}

	/**
	 * 
	 * @return String
	 */
	public String toString() {
		return String.valueOf(value);
	}

}
