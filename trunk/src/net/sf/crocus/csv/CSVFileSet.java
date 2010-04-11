package net.sf.crocus.csv;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import net.sf.crocus.csv.record.AbstractCSVRecordManager;
import net.sf.crocus.csv.record.RecordManagerFactory;


public class CSVFileSet extends AbstractCSVFileSet {

	private ArrayList<CSVFile> list = null;

	private AbstractCSVRecordManager recordManager = null;

	public CSVFileSet() {
		list = new ArrayList<CSVFile>();
		recordManager = RecordManagerFactory.getInstance()
				.getDefaultRecordManager();

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
	public Collection<CSVFile> getFiles() {
		// TODO Auto-generated method stub
		return this.list;
	}

	@Override
	public AbstractCSVRecordManager getRecordManager() {
		// TODO Auto-generated method stub
		return this.recordManager;
	}

}
