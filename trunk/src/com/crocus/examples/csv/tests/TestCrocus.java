package com.crocus.examples.csv.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.crocus.examples.csv.AbstractCSVFileSet;
import com.crocus.examples.csv.CSVConstants;
import com.crocus.examples.csv.CSVFileSet;
import com.crocus.examples.csv.CSVFileSetInterface;
import com.crocus.examples.csv.CSVSingleFileInterface;
import com.crocus.examples.csv.event.RecordEvent;
import com.crocus.examples.csv.event.RecordListener;
import com.crocus.examples.csv.record.AbstractCSVRecordManager;

import junit.framework.TestCase;

public class TestCrocus extends TestCase implements RecordListener {

	public void testRead() throws FileNotFoundException, IOException {

		CSVSingleFileInterface fileInterface = new CSVSingleFileInterface(
				"/media/data/dev/workspace/crocus/testData/drupal-sample.csv",
				CSVConstants.COMMA);

		AbstractCSVRecordManager manager = fileInterface.getRecordManager();

		manager.addRecordListener(this);

		manager = fileInterface.read();

		System.out.println(manager.getAllRecords());

		AbstractCSVFileSet fileSet = new CSVFileSet();

		CSVFileSetInterface fileSetInterface = new CSVFileSetInterface(fileSet);

		fileSet
				.addFile("/media/data/dev/workspace/crocus/testData/drupal-sample.csv");
		fileSet
				.addFile("/media/data/dev/workspace/crocus/testData/countries.csv");

		System.out.println("Reading");
		AbstractCSVRecordManager manager1 = fileSetInterface.read();

		System.out.println(manager.getAllRecords());

		fail("Not yet implemented");
	}

	public void eventPerformed(RecordEvent recordEvent) {
		System.out.println(recordEvent.toString());

	}

}
