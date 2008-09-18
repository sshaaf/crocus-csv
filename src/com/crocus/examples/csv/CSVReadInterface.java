package com.crocus.examples.csv;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.crocus.examples.csv.record.AbstractCSVRecordManager;

public interface CSVReadInterface {

	public AbstractCSVRecordManager read() throws IOException,FileNotFoundException;
	
}
