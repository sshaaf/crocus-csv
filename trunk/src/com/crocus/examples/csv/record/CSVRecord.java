package com.crocus.examples.csv.record;

/**
 * <p>Title: </p>
 *
 * <p>Description: A line in thge csv file represents a record</p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
import java.io.Serializable;
import java.util.Collection;
import java.util.regex.Pattern;

import com.crocus.examples.csv.CSVConstants;
import com.crocus.examples.csv.fields.CSVField;

public abstract class CSVRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9094172675032236917L;

	protected char DELIMINATOR = CSVConstants.COMMA;
	
	public CSVRecord(){}
	
	public CSVRecord(char DELIMINATOR) {
		this.DELIMINATOR = DELIMINATOR;
	}

	/**
	 * 
	 * @param csvField
	 *            CSVField
	 */
	public abstract void addField(CSVField csvField);

	
	
	/**
	 * 
	 * @param csvField
	 *            CSVField
	 */
	public abstract void removeField(CSVField csvField);

	/**
	 * 
	 * @param csvField
	 *            CSVField
	 * @return boolean
	 */
	public abstract boolean contains(CSVField csvField);

	/**
	 * 
	 * @return Object[]
	 */
	public abstract Object[] getArrayOfRecords();

	/**
	 * 
	 * @return int
	 */
	public abstract int getColumnCount();

	/**
	 * 
	 * @param columnIndex
	 *            int
	 * @return CSVField
	 */
	public abstract CSVField getColumn(int columnIndex);

	/**
	 * 
	 * @param columnIndex
	 *            int
	 * @param csvField
	 *            CSVField
	 * @return CSVField
	 */
	public abstract CSVField replaceColumn(int columnIndex, CSVField csvField);

	/**
	 * 
	 * @param field
	 *            String
	 * @return boolean
	 */
	public abstract boolean contains(String field);

	/**
	 * 
	 * @param deliminator
	 *            char
	 * @return String
	 */
	public abstract String toString(char deliminator);
	
	
	/**
	 * Check a record against a regular expression. 
	 * This only checks against each field not as a record.
	 * @param pattern
	 * @return
	 */
	public abstract boolean containsInField(Pattern pattern);
	
	
	/**
	 * Check a record against a regular expression. 
	 * This only checks against the record not each field..
	 * @param pattern
	 * @return
	 */
	public abstract boolean containsInRecord(Pattern pattern);
	
	
	public abstract Collection<CSVField> getFields();
	
}
