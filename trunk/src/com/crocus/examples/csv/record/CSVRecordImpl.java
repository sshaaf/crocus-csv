package com.crocus.examples.csv.record;

import com.crocus.examples.csv.fields.CSVField;
import java.util.ArrayList;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: Implementation of the Record
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
public class CSVRecordImpl extends CSVRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2244986568046868067L;

	private ArrayList<CSVField> fieldList = null;

	public CSVRecordImpl() {
		fieldList = new ArrayList<CSVField>();

	}

	/**
	 * 
	 * @param csvField
	 *            CSVField
	 */
	public void addField(CSVField csvField) {
		fieldList.add(csvField);
	}

	/**
	 * 
	 * @param csvField
	 *            CSVField
	 */
	public void removeField(CSVField csvField) {
		fieldList.remove(csvField);
	}

	/**
	 * 
	 * @param csvField
	 *            CSVField
	 * @return boolean
	 */
	public boolean contains(CSVField csvField) {
		return fieldList.contains(csvField);
	}

	/**
	 * 
	 * @return Object[]
	 */
	public Object[] getArrayOfRecords() {
		return fieldList.toArray();
	}

	/**
	 * 
	 * @return int
	 */
	public int getColumnCount() {
		return fieldList.size();
	}

	/**
	 * 
	 * @param columnIndex
	 *            int
	 * @return CSVField
	 */
	public CSVField getColumn(int columnIndex) {
		return fieldList.get(columnIndex);
	}

	/**
	 * 
	 * @param columnIndex
	 *            int
	 * @param csvField
	 *            CSVField
	 * @return CSVField
	 */
	public CSVField replaceColumn(int columnIndex, CSVField csvField) {
		fieldList.remove(columnIndex);
		fieldList.add(columnIndex, csvField);
		return fieldList.get(columnIndex);
	}

	/**
	 * 
	 * @param field
	 *            String
	 * @return boolean
	 */
	public boolean contains(String field) {
		for (CSVField a : fieldList)
			if (a.toString().equals(field))
				return true;
		return false;
	}

	public String toString() {
		String tempString = fieldList.get(0).toString();
		for (int i = 0; i < this.getColumnCount(); i++) {
			tempString += "," + fieldList.get(i);

		}
		return tempString;
	}

	public String toString(char deliminator) {
		String tempString = fieldList.get(0).toString();
		for (int i = 0; i < this.getColumnCount(); i++) {
			tempString += deliminator + "" + fieldList.get(i);

		}
		return tempString;
	}
}
