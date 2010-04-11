package net.sf.crocus.csv;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.crocus.csv.record.AbstractCSVRecordManager;


public interface CSVReadInterface {

	public AbstractCSVRecordManager read() throws IOException,
			FileNotFoundException;

}
