package net.sf.crocus.csv.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import net.sf.crocus.csv.AbstractCSVFileSet;
import net.sf.crocus.csv.CSVConstants;
import net.sf.crocus.csv.CSVFileSet;
import net.sf.crocus.csv.CSVFileSetInterface;
import net.sf.crocus.csv.CSVSingleFileInterface;
import net.sf.crocus.csv.event.RecordEvent;
import net.sf.crocus.csv.event.RecordListener;
import net.sf.crocus.csv.record.AbstractCSVRecordManager;
import net.sf.crocus.csv.record.CSVRecord;


import junit.framework.TestCase;

public class TestCrocus extends TestCase{

	public void testRead() throws FileNotFoundException, IOException {

		
		CSVSingleFileInterface fileInterface = new CSVSingleFileInterface("/media/data/dev/java2se/crocus/testData/VEJLDB.csv", CSVConstants.COMMA, true);

		AbstractCSVRecordManager manager = fileInterface.getRecordManager();

		manager = fileInterface.read();
		long current = System.currentTimeMillis();
		System.out.println(manager.getAllRecords().size());
		System.out.println("search time: "+ (System.currentTimeMillis() - current));
//		Collection<CSVRecord> records = manager.getRecords(Pattern.compile(".*LexCom.*"));
//		manager.setFirstRowNames(true);
//		System.out.println(records.size());
//		
//		System.out.println(manager.getJSON(records));
//		System.out.println(manager.getColumnNames());
	}



}
