package com.crocus.examples.csv;

import com.crocus.examples.csv.record.CSVRecord;

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
public abstract class AbstractCSVFieldReader {

	/**
	 * Holds the current line in the Buffer
	 */
	protected char[] charLine = null;

	/**
	 * Holds the count of character on the currentLine
	 */
	protected int counter = 0;

	/**
	 * Holds the deliminator else by DEAFULT value is CSVConstants.COMMA
	 */
	private char deliminator = CSVConstants.COMMA;

	/**
	 * 
	 * @param charLine
	 *            char[]
	 */
	public AbstractCSVFieldReader(char[] charLine) {
		this.charLine = charLine;
	}

	/**
	 * 
	 * @param charLine
	 *            char[]
	 * @param deliminator
	 *            char
	 */
	public AbstractCSVFieldReader(char[] charLine, char deliminator) {
		this.charLine = charLine;
		this.deliminator = deliminator;
	}

	/**
	 * Execution Logic
	 */
	public abstract CSVRecord execute();

	/**
	 * Extracts a Field from the currentLine as a String
	 * 
	 * @return String
	 */
	protected abstract String getField();

	public char getDeliminator() {
		return deliminator;
	}
}
