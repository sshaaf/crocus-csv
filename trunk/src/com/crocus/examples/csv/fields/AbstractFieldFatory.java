package com.crocus.examples.csv.fields;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: An abstract for Fields Factories
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
public abstract class AbstractFieldFatory {
	public AbstractFieldFatory() {
	}

	/**
	 * 
	 * @param value
	 *            String
	 * @return CSVField
	 */
	public abstract CSVField getType(String value);

	/**
	 * 
	 * @param FIELD
	 *            int
	 * @return String
	 */
	public abstract String getType(int FIELD);

	/**
	 * 
	 * @param FIELD
	 *            int
	 * @param value
	 *            String
	 * @return CSVField
	 */
	public abstract CSVField getType(int FIELD, String value);
}
