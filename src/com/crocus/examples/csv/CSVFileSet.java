package com.crocus.examples.csv;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import com.crocus.examples.csv.record.AbstractCSVRecordManager;
import com.crocus.examples.csv.record.RecordManagerFactory;


public class CSVFileSet extends AbstractCSVFileSet {

	private ArrayList<CSVFile> list = null;

	private AbstractCSVRecordManager recordManager = null;

	public CSVFileSet() {
		list = new ArrayList<CSVFile>();
		recordManager = RecordManagerFactory.getInstance().getDefaultRecordManager();

	}

	public CSVFileSet(AbstractCSVRecordManager recordManager) {
		list = new ArrayList<CSVFile>();
		this.recordManager = recordManager;

	}

	@Override
	public void addFile(String fileName, char deliminator)
			throws FileNotFoundException {
		list.add(new CSVFileImpl(fileName, deliminator, recordManager));

	}

	@Override
	public void addFile(String fileName) throws FileNotFoundException {
		list.add(new CSVFileImpl(fileName, CSVConstants.COMMA, recordManager));

	}

	@Override
	public CSVFile getFile(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection getFiles() {
		// TODO Auto-generated method stub
		return this.list;
	}

	@Override
	public AbstractCSVRecordManager getRecordManager() {
		// TODO Auto-generated method stub
		return this.recordManager;
	}

}
