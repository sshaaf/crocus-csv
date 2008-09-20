package com.crocus.examples.csv;

/**
 * <p>Title: </p>
 *
 * <p>Description: A CSVFile Implementation</p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */

import java.io.File;
import java.io.FileNotFoundException;

import com.crocus.examples.csv.record.AbstractCSVRecordManager;
import com.crocus.examples.csv.record.CSVRecordManager;
import com.crocus.examples.csv.record.RecordManagerFactory;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.PrintStream;
import com.crocus.examples.csv.record.CSVRecord;

public class CSVFileImpl extends File implements CSVFile {

	private boolean isLocked = false;

	private AbstractCSVRecordManager csvRecordManager = null;

	private FileWriter fWriter = null;

	private BufferedWriter bWriter = null;

	private FileOutputStream out; // declare a file output object

	private PrintStream p; // declare a print stream object

	private char deliminator;

	/**
	 * Get the File from the path mentioned in String
	 * 
	 * @param fileName
	 *            String
	 * @throws FileNotFoundException
	 */
	public CSVFileImpl(String fileName, char deliminator)
			throws FileNotFoundException {
		super(fileName);
		this.deliminator = deliminator;
		csvRecordManager = RecordManagerFactory.getInstance()
				.getDefaultRecordManager();
	}

	/**
	 * Get the File from the path mentioned in String
	 * 
	 * @param fileName
	 *            String
	 * @param csvRecordManager
	 *            CSVRecordManager
	 * @throws FileNotFoundException
	 */
	public CSVFileImpl(String fileName, char deliminator,
			AbstractCSVRecordManager csvRecordManager)
			throws FileNotFoundException {
		super(fileName);
		this.deliminator = deliminator;
		this.csvRecordManager = csvRecordManager;
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public synchronized void openFile() throws FileNotFoundException {
		out = new FileOutputStream(this);

		// Connect print stream to the output stream
		p = new PrintStream(out);
	}

	/**
	 * 
	 * @throws IOException
	 */
	public synchronized void write() throws IOException {
		for (int rowIndex = 0; rowIndex < getCSVRecordManager().getRowCount(); rowIndex++) {
			p.println(getCSVRecordManager().getRow(rowIndex).toString(
					this.deliminator));
		}
	}

	/**
	 * Check the lock for the file
	 * 
	 * @return boolean
	 */
	public boolean isLocked() {
		return isLocked;
	}

	public AbstractCSVRecordManager getCSVRecordManager() {
		return csvRecordManager;
	}

	public char getDeliminator() {
		return this.deliminator;
	}

}
