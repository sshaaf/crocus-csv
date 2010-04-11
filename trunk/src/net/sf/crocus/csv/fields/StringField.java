package net.sf.crocus.csv.fields;

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
	 * @return String
	 */
	public String toString() {
		return value;
	}

}
