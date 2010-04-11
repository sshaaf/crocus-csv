package net.sf.crocus.csv.record;

import net.sf.crocus.csv.fields.CSVField;

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

	public abstract boolean isMultipleFileSupported();

	public abstract void setMultipleFileSupported(boolean isEnabled);
}
