package com.crocus.examples.csv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.crocus.examples.csv.record.AbstractCSVRecordManager;
import com.crocus.examples.csv.record.RecordManagerFactory;

public class CSVFileSetInterface implements CSVReadInterface{

	private AbstractCSVFileSet fileSet = null;

	private AbstractCSVRecordManager recordManager = null;

	public CSVFileSetInterface() {
		recordManager = RecordManagerFactory.getInstance().getDefaultRecordManager();
	}

	public CSVFileSetInterface(AbstractCSVFileSet fileSet) {
		recordManager = RecordManagerFactory.getInstance().getDefaultRecordManager();
		setFileSet(fileSet);
	}

	public void setFileSet(AbstractCSVFileSet fileSet) {
		this.fileSet = fileSet;
	}

	public void setFile(String fileName) throws FileNotFoundException {
		fileSet = new CSVFileSet();
		fileSet.addFile(fileName);
	}

	public void setFile(String fileName, char deliminator) throws FileNotFoundException {
		fileSet = new CSVFileSet();
		fileSet.addFile(fileName, deliminator);
	}

    /**
    *
    * @return CSVRecordManager
    * @throws IOException
    * @throws FileNotFoundException
    */
   public AbstractCSVRecordManager read() throws IOException,FileNotFoundException {
       
	   Collection c = fileSet.getFiles();
	   
	   Iterator iterator = c.iterator();
	   
	   while(iterator.hasNext()){
		   
		   CSVFile csvFile = (CSVFile)iterator.next();
		   AbstractCSVReader reader = null;
           reader = new CSVReaderImpl(csvFile, csvFile.getDeliminator());
           while (reader.readNextLine())
           {
           }
		   
	   }
           
       return fileSet.getRecordManager();
   }

	
}
