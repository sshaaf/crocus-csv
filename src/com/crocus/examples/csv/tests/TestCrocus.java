package com.crocus.examples.csv.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import com.crocus.examples.csv.AbstractCSVFileSet;
import com.crocus.examples.csv.CSVConstants;
import com.crocus.examples.csv.CSVFileSet;
import com.crocus.examples.csv.CSVFileSetInterface;
import com.crocus.examples.csv.CSVSingleFileInterface;
import com.crocus.examples.csv.event.RecordEvent;
import com.crocus.examples.csv.event.RecordListener;
import com.crocus.examples.csv.record.AbstractCSVRecordManager;
import com.crocus.examples.csv.record.CSVRecord;

import junit.framework.TestCase;

public class TestCrocus extends TestCase{

	public void testRead() throws FileNotFoundException, IOException {

//		CSVSingleFileInterface fileInterface = new CSVSingleFileInterface(
//				"/media/data/dev/java2se/crocus/testData/drupal-sample.csv",
//				CSVConstants.COMMA);
//
//		AbstractCSVRecordManager manager = fileInterface.getRecordManager();
//
//		manager.addRecordListener(this);
//
//		manager = fileInterface.read();
//
//		System.out.println(manager.getAllRecords());
//
//		AbstractCSVFileSet fileSet = new CSVFileSet();
//
//		CSVFileSetInterface fileSetInterface = new CSVFileSetInterface(fileSet);
//
//		fileSet
//				.addFile("/media/data/dev/java2se/crocus/testData/drupal-sample.csv");
//		fileSet
//				.addFile("/media/data/dev/java2se/crocus/testData/countries.csv");
//
//		System.out.println("Reading");
//		AbstractCSVRecordManager manager1 = fileSetInterface.read();
//
//		System.out.println(manager.getAllRecords());
		
		
		CSVSingleFileInterface fileInterface = new CSVSingleFileInterface("/media/data/dev/java2se/crocus/testData/VEJLDB.csv", CSVConstants.COMMA, true);

		AbstractCSVRecordManager manager = fileInterface.getRecordManager();

		manager = fileInterface.read();
		long current = System.currentTimeMillis();
		Collection<CSVRecord> records = manager.getRecords(Pattern.compile(".*LexCom pa.*"));
		System.out.println("search time: "+ (System.currentTimeMillis() - current));
		
		System.out.println(records.size());
		
		System.out.println(manager.getJSON(records));
		
		fail("Not yet implemented");
	}



}
