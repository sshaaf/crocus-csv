package com.crocus.examples.csv;

import java.io.FileNotFoundException;
import java.util.Collection;

import com.crocus.examples.csv.record.AbstractCSVRecordManager;

public abstract class AbstractCSVFileSet {

	
	public abstract void addFile(String fileName, char deliminator) throws FileNotFoundException;
	
	public abstract void addFile(String fileName) throws FileNotFoundException;
	
	public abstract Collection getFiles();
	
	public abstract CSVFile getFile(String fileName);
	
	public abstract AbstractCSVRecordManager getRecordManager();
	
}
