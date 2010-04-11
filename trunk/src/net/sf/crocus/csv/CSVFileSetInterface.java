package net.sf.crocus.csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import net.sf.crocus.csv.record.AbstractCSVRecordManager;
import net.sf.crocus.csv.record.RecordManagerFactory;


public class CSVFileSetInterface implements CSVReadInterface {

	private AbstractCSVFileSet fileSet = null;

	private AbstractCSVRecordManager recordManager = null;

	public CSVFileSetInterface() {
		recordManager = RecordManagerFactory.getInstance()
				.getDefaultRecordManager();
	}

	public CSVFileSetInterface(AbstractCSVFileSet fileSet) {
		recordManager = RecordManagerFactory.getInstance()
				.getDefaultRecordManager();
		setFileSet(fileSet);
	}

	public void setFileSet(AbstractCSVFileSet fileSet) {
		this.fileSet = fileSet;
	}

	public void setFile(String fileName) throws FileNotFoundException {
		fileSet = new CSVFileSet();
		fileSet.addFile(fileName);
	}

	public void setFile(String fileName, char deliminator)
			throws FileNotFoundException {
		fileSet = new CSVFileSet();
		fileSet.addFile(fileName, deliminator);
	}

	/**
	 * 
	 * @return CSVRecordManager
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public AbstractCSVRecordManager read() throws IOException,
			FileNotFoundException {

		Collection<CSVFile> c = fileSet.getFiles();

		Iterator<CSVFile> iterator = c.iterator();

		while (iterator.hasNext()) {

			CSVFile csvFile = iterator.next();
			CSVBufferedReader reader = null;
			reader = new CSVBufferedReaderImpl(new FileReader((File)csvFile));
			while (reader.readNextLine()) {
			}

		}

		return fileSet.getRecordManager();
	}

}
