package net.sf.crocus.csv;

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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import net.sf.crocus.csv.record.AbstractCSVRecordManager;
import net.sf.crocus.csv.record.RecordManagerFactory;


public class CSVFileImpl extends File implements CSVFile {

	private boolean isLocked = false;

	private AbstractCSVRecordManager csvRecordManager = null;

	private FileOutputStream out; // declare a file output object

	private PrintStream p; // declare a print stream object

	private char deliminator;
	
	public boolean isFirstRowNames = false;

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
	
	
	public CSVFileImpl(String fileName, char deliminator,
			boolean isFirstRowNames) throws FileNotFoundException {
		super(fileName);
		this.deliminator = deliminator;
		this.isFirstRowNames = isFirstRowNames;
		csvRecordManager = RecordManagerFactory.getInstance()
				.getDefaultRecordManager();
		csvRecordManager.setFirstRowNames(isFirstRowNames);
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

	public CSVFileImpl(String fileName, char deliminator,
			AbstractCSVRecordManager csvRecordManager, boolean isFirstRowNames)
			throws FileNotFoundException {
		super(fileName);
		this.deliminator = deliminator;
		this.isFirstRowNames = isFirstRowNames;
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

	@Override
	public boolean isFirstRowNames() {
		return isFirstRowNames;
	}

	protected void setFirstRowNames(boolean isFirstRowNames) {
		this.isFirstRowNames = isFirstRowNames;
	}
	
}
