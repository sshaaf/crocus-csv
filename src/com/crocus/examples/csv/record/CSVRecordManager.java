package com.crocus.examples.csv.record;

import com.crocus.examples.csv.fields.CSVField;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: A Record Manager
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
public abstract class CSVRecordManager extends AbstractCSVRecordManager {

	public CSVRecordManager() {
	}

	/**
	 * 
	 * @param rowIndex
	 *            int
	 * @param columnIndex
	 *            int
	 * @param FIELD
	 *            int
	 * @return CSVField
	 */
	public abstract CSVField getConvertField(int rowIndex, int columnIndex,
			int FIELD);

	public abstract boolean isMultipleFileSupported();

	public abstract void setMultipleFileSupported(boolean isEnabled);
}
