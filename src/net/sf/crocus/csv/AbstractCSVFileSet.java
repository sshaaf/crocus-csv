package net.sf.crocus.csv;

import java.io.FileNotFoundException;
import java.util.Collection;

import net.sf.crocus.csv.record.AbstractCSVRecordManager;


public abstract class AbstractCSVFileSet {

	public abstract void addFile(String fileName, char deliminator)
			throws FileNotFoundException;

	public abstract void addFile(String fileName) throws FileNotFoundException;

	public abstract Collection<CSVFile> getFiles();

	public abstract CSVFile getFile(String fileName);

	public abstract AbstractCSVRecordManager getRecordManager();

}
