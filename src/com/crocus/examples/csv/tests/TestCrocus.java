package com.crocus.examples.csv.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.crocus.examples.csv.AbstractCSVFileSet;
import com.crocus.examples.csv.CSVFileSet;
import com.crocus.examples.csv.CSVFileSetInterface;
import com.crocus.examples.csv.record.AbstractCSVRecordManager;


import junit.framework.TestCase;

public class TestCrocus extends TestCase {

	public void testRead() throws FileNotFoundException, IOException {
		
		
		
		AbstractCSVFileSet fileSet = new CSVFileSet();
		
		CSVFileSetInterface fileSetInterface = new CSVFileSetInterface(fileSet);
		
		fileSet.addFile("/media/data/dev/workspace/crocus/testData/drupal-sample.csv");
		fileSet.addFile("/media/data/dev/workspace/crocus/testData/countries.csv");
		
        System.out.println("Reading");
        AbstractCSVRecordManager manager = fileSetInterface.read();
		
        System.out.println(manager.getAllRecords());

		fail("Not yet implemented");
	}

}
