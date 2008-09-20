package com.crocus.examples.csv.fields;

import com.crocus.examples.csv.CSVConstants;
import java.text.ParseException;

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
public class FieldFactory extends AbstractFieldFatory {

	private static FieldFactory fieldFactory;

	private FieldFactory() {
	}

	/**
	 * 
	 * @return FieldFactory
	 */
	public static FieldFactory getInstance() {
		if (fieldFactory != null)
			return fieldFactory;
		else
			return fieldFactory = new FieldFactory();
	}

	/**
	 * 
	 * @param FIELD
	 *            int
	 * @param value
	 *            String
	 * @return CSVField
	 */
	public CSVField getType(int FIELD, String value) {
		CSVField csvField = null;
		try {

			switch (FIELD) {
			case FieldConstants.DOUBLE:
				csvField = new DoubleField(Double.valueOf(value));
				break;
			case FieldConstants.LONG:
				csvField = new LongField(Long.valueOf(value));
				break;
			case FieldConstants.STRING:
				csvField = new StringField(String.valueOf(value));
				break;
			case FieldConstants.SIMPLE_DATE:
				csvField = new DateField(value.trim());
				break;
			default:
				System.out.println("Field Not Type Unknown");
			}
		} catch (Exception e) {
			if (e instanceof NumberFormatException
					|| e instanceof ParseException)
				System.out.println("Number Format Exception");
		}
		return csvField;
	}

	/**
	 * 
	 * @param FIELD
	 *            int
	 * @return String
	 */
	public String getType(int FIELD) {
		String tempString = null;
		switch (FIELD) {
		case FieldConstants.DOUBLE:
			tempString = "DOUBLE";
			break;
		case FieldConstants.LONG:
			tempString = "LONG";
			break;
		case FieldConstants.STRING:
			tempString = "STRING";
			break;
		case FieldConstants.SIMPLE_DATE:
			tempString = "Date";
			break;
		default:
			System.out.println("Field Not Type Unknown");
			tempString = "UNKNOWN";
		}
		return tempString;
	}

	/**
	 * 
	 * @param value
	 *            String
	 * @return CSVField
	 */
	public CSVField getType(String value) {
		CSVField csvField;
		String tempString = new String();
		if (value == null || value.equals(""))
			return new StringField(value.toString());
		if (value.charAt(0) == CSVConstants.QUOTE
				&& value.length() - 1 == CSVConstants.QUOTE) {
			tempString = value.substring(1, value.length() - 2);
		}

		tempString = value.toString();
		try {
			csvField = new LongField(Long.valueOf(value.toString().trim()));
			return csvField;
		} catch (NumberFormatException nfe) {
		}

		if (value.indexOf(".") >= 0) {
			try {
				csvField = new DoubleField(Double.valueOf(value.toString()
						.trim()));
				return csvField;
			} catch (NumberFormatException nfe) {
			}
		}
		csvField = new StringField(value.toString());
		return csvField;
	}

}
