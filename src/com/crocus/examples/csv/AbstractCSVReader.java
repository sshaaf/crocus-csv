package com.crocus.examples.csv;

/**
 * <p>Title: </p>
 *
 * <p>Description: an Abstract version of the Reader </p>
 *
 * <p>Copyright: </p>
 *
 * <p>Company: </p>
 *
 * @author M Shaaf
 * @email shaaf.m@gmail.com
 */
import com.crocus.examples.csv.fields.CSVField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public abstract class AbstractCSVReader extends BufferedReader {

    protected StringBuffer currentLine;

    public AbstractCSVReader(CSVFile file) throws FileNotFoundException {
        super(new FileReader((File) file));
    }

    public abstract boolean readNextLine() throws IOException;
}
