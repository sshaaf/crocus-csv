package com.crocus.examples.csv;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */

import java.io.IOException;
import java.io.FileNotFoundException;

public class CSVReaderImpl extends AbstractCSVReader {

	private CSVFile csvFile = null;

	private char deliminator;

	/**
	 * 
	 * @param file
	 *            CSVFile
	 * @throws FileNotFoundException
	 */
	public CSVReaderImpl(CSVFile file) throws FileNotFoundException {
		super(file);
		this.csvFile = file;
		this.deliminator = CSVConstants.COMMA;
	}

	public CSVReaderImpl(CSVFile file, char deliminator)
			throws FileNotFoundException {
		super(file);
		this.csvFile = file;
		this.deliminator = deliminator;
	}

	/**
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean readNextLine() throws IOException {
		String curLine = super.readLine();
		if (curLine != null) {
			currentLine = new StringBuffer(curLine);
			CSVFieldReader fieldReader = new CSVFieldReader(currentLine
					.toString().toCharArray(), this.deliminator);
			csvFile.getCSVRecordManager().addRecord(fieldReader.execute());
		} else
			currentLine = null;
		return currentLine != null;
	}

}
