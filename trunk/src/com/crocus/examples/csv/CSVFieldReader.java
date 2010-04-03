package com.crocus.examples.csv;

import com.crocus.examples.csv.record.CSVRecord;
import com.crocus.examples.csv.record.RecordManagerFactory;
import com.crocus.examples.csv.fields.FieldFactory;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: Field by Field Manipulation
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

public class CSVFieldReader extends AbstractCSVFieldReader {

	/**
	 * The Record that corresponds to the currentLine
	 */
	protected CSVRecord csvRecord = null;

	/**
	 * Send me a currentLine from teh buffer to manipulate the fields.
	 * 
	 * @param charLine
	 *            char[]
	 */
	public CSVFieldReader(char[] charLine) {
		super(charLine);
		csvRecord = RecordManagerFactory.getInstance().getNewRecord();
	}

	public CSVFieldReader(char[] charLine, char deliminator) {
		super(charLine, deliminator);
		csvRecord = RecordManagerFactory.getInstance().getNewRecord();
	}

	public CSVFieldReader(char[] charLine, char deliminator, CSVRecord csvRecord) {
		super(charLine, deliminator);
		this.csvRecord = csvRecord;
	}

	/**
	 * Execution Logic
	 */
	public CSVRecord execute() {
		while (counter < charLine.length) {
			csvRecord.addField(FieldFactory.getInstance().getType(getField()));
		}
		return csvRecord;
	}

	/**
	 * Extracts a Field from the currentLine as a String
	 * 
	 * @return String
	 */
	protected String getField() {
		String tempString = new String();
		if (charLine[counter] == CSVConstants.QUOTE) {
			counter++;
			while (charLine[counter] != CSVConstants.QUOTE) {
				tempString += String.valueOf(charLine[counter]);
				counter++;
				if (counter == charLine.length)
					return tempString;
			}
			counter++;
			if (!(counter == charLine.length)) {
				counter++;
			}
			return tempString;
		} else {
			while (charLine[counter] != getDeliminator()) {
				tempString += String.valueOf(charLine[counter]);
				counter++;
				if (counter == charLine.length)
					return tempString;
			}
			counter++;
			return tempString;
		}
	}
}
