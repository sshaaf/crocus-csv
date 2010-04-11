package net.sf.crocus.csv;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.crocus.csv.record.AbstractCSVRecordManager;


/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: Interface defining a few methods for a CSVFile
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
public interface CSVFile {
	public AbstractCSVRecordManager getCSVRecordManager();

	public void openFile() throws FileNotFoundException;

	public void write() throws IOException;

	public char getDeliminator();
	
	public boolean isFirstRowNames();
}
