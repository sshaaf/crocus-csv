package com.crocus.examples.csv;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.crocus.examples.csv.record.AbstractCSVRecordManager;
import com.crocus.examples.csv.record.CSVRecordManager;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: The main class for the system Launch
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
public class CSVSingleFileInterface implements CSVReadInterface {

	private CSVFile csvFile = null;

	private AbstractCSVRecordManager recordManager = null;

	private AbstractCSVFileSet csvFileSet = null;

	/**
	 * 
	 * @throws IOException
	 */
	public CSVSingleFileInterface(String fileName, char deliminator)
			throws FileNotFoundException {
		csvFile = new CSVFileImpl(fileName, deliminator);
	}

	public CSVSingleFileInterface(String fileName, char deliminator, boolean isFirstRowNames)
	throws FileNotFoundException {
		csvFile = new CSVFileImpl(fileName, deliminator, isFirstRowNames);
	}
	
	public CSVSingleFileInterface(AbstractCSVFileSet csvFileSet) {

	}

	/**
	 * 
	 * @param fileName
	 *            String
	 * @throws FileNotFoundException
	 */
	public CSVSingleFileInterface(String fileName) throws FileNotFoundException {
		csvFile = new CSVFileImpl(fileName, CSVConstants.COMMA);
	}

	public CSVSingleFileInterface(String fileName, boolean isFirstRowNames) throws FileNotFoundException {
		csvFile = new CSVFileImpl(fileName, CSVConstants.COMMA, isFirstRowNames);
	}
	
	/**
	 * 
	 * @param fileName
	 *            String
	 * @param deliminator
	 *            char
	 * @param csvRecordManager
	 *            CSVRecordManager
	 * @throws FileNotFoundException
	 */
	public CSVSingleFileInterface(String fileName, char deliminator,
			CSVRecordManager csvRecordManager) throws FileNotFoundException {
		csvFile = new CSVFileImpl(fileName, deliminator, csvRecordManager);
	}

	public CSVSingleFileInterface(String fileName, char deliminator,
			CSVRecordManager csvRecordManager, boolean isFirstRowNames) throws FileNotFoundException {
		csvFile = new CSVFileImpl(fileName, deliminator, csvRecordManager, isFirstRowNames);
	}
	
	/**
	 * 
	 * @return CSVRecordManager
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public AbstractCSVRecordManager read() throws IOException,
			FileNotFoundException {
		AbstractCSVReader reader = null;
		reader = new CSVReaderImpl(csvFile, csvFile.getDeliminator());
		while (reader.readNextLine()) {
		}
		return csvFile.getCSVRecordManager();
	}

	public void write(CSVFile newCsvFile) throws FileNotFoundException,
			IOException {
		newCsvFile.openFile();
		newCsvFile.write();
	}

	/**
	 * 
	 * @return CSVRecordManager
	 */
	public AbstractCSVRecordManager getRecordManager() {
		return csvFile.getCSVRecordManager();
	}

	public CSVFile getCSVFile() {
		return this.csvFile;
	}

	public static void main(String args[]) throws IOException {
		CSVSingleFileInterface c = new CSVSingleFileInterface(args[0],
				CSVConstants.TAB);
		System.out.println("Reading");
		c.read();
		System.out.println("Writing");
		c.write(new CSVFileImpl("/home/wiz/ocitrace_testData/tempFileTest.csv",
				CSVConstants.SEMI_COLON, c.csvFile.getCSVRecordManager()));
	}

}
