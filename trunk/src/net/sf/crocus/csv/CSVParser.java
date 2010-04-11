package net.sf.crocus.csv;

import net.sf.crocus.csv.record.CSVRecord;

public abstract class CSVParser {

	/**
	 * Holds the deliminator else by DEAFULT value is CSVConstants.COMMA
	 */
	private char deliminator = CSVConstants.COMMA;

	/**
	 * 
	 * @param charLine
	 *            char[]
	 * @param deliminator
	 *            char
	 */
	public CSVParser(char deliminator) {
		this.deliminator = deliminator;
	}

	public char getDeliminator() {
		return deliminator;
	}
	
	public void setDeliminator(char deliminator) {
		this.deliminator = deliminator;
	}

	public abstract CSVRecord parse(char[] curLine);
}
